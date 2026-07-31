-- =========================================================
-- LifeLine Blood Bank Management System - MySQL Schema
-- =========================================================
CREATE DATABASE IF NOT EXISTS bbms_db;
USE bbms_db;

CREATE TABLE IF NOT EXISTS admins (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,       -- BCrypt hash
    full_name VARCHAR(100),
    role VARCHAR(20) DEFAULT 'ADMIN',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS donors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    donor_code VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10) NOT NULL,
    blood_group VARCHAR(3) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    address VARCHAR(255),
    last_donation_date DATE,
    eligibility_status VARCHAR(20) DEFAULT 'Eligible',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_donor_blood_group (blood_group),
    INDEX idx_donor_name (name)
);

CREATE TABLE IF NOT EXISTS patients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    patient_code VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    hospital VARCHAR(150) NOT NULL,
    blood_group_required VARCHAR(3) NOT NULL,
    units_required INT NOT NULL,
    doctor_name VARCHAR(100),
    priority_level VARCHAR(10) DEFAULT 'Normal',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_patient_blood_group (blood_group_required)
);

CREATE TABLE IF NOT EXISTS blood_units (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    blood_group VARCHAR(3) NOT NULL UNIQUE,   -- one row per group acts as the HashMap-backing table
    units_available INT NOT NULL DEFAULT 0,
    expiry_date DATE,
    storage_status VARCHAR(20) DEFAULT 'In Stock',   -- In Stock / Low Stock / Out of Stock
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS blood_requests (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    request_code VARCHAR(20) NOT NULL UNIQUE,
    patient_id BIGINT,
    patient_name VARCHAR(100),
    blood_group VARCHAR(3) NOT NULL,
    units_requested INT NOT NULL,
    status VARCHAR(30) DEFAULT 'Pending',  -- Pending / Issued / Waiting / Rejected
    request_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    resolved_date TIMESTAMP NULL,
    FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE SET NULL,
    INDEX idx_request_blood_group (blood_group),
    INDEX idx_request_status (status)
);

CREATE TABLE IF NOT EXISTS emergency_requests (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    request_code VARCHAR(20) NOT NULL UNIQUE,
    patient_id BIGINT,
    patient_name VARCHAR(100),
    blood_group VARCHAR(3) NOT NULL,
    units_required INT NOT NULL,
    priority_level VARCHAR(10) NOT NULL,   -- Critical / High / Medium / Normal
    priority_weight INT NOT NULL,          -- Critical=4, High=3, Medium=2, Normal=1 (drives PriorityQueue ordering)
    status VARCHAR(20) DEFAULT 'Queued',   -- Queued / Processed / Escalated
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    processed_at TIMESTAMP NULL,
    FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE SET NULL,
    INDEX idx_emergency_priority (priority_weight, created_at)
);

CREATE TABLE IF NOT EXISTS waiting_queue (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    queue_code VARCHAR(20) NOT NULL UNIQUE,
    patient_id BIGINT,
    patient_name VARCHAR(100),
    blood_group VARCHAR(3) NOT NULL,
    units_required INT NOT NULL,
    queued_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,   -- FIFO ordering column
    status VARCHAR(20) DEFAULT 'Waiting',            -- Waiting / Fulfilled / Cancelled
    fulfilled_at TIMESTAMP NULL,
    FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE SET NULL,
    INDEX idx_waiting_group_time (blood_group, queued_at)
);

-- seed the 8 canonical blood groups
INSERT INTO blood_units (blood_group, units_available, expiry_date, storage_status)
VALUES ('A+',0,NULL,'Out of Stock'),('A-',0,NULL,'Out of Stock'),('B+',0,NULL,'Out of Stock'),
       ('B-',0,NULL,'Out of Stock'),('AB+',0,NULL,'Out of Stock'),('AB-',0,NULL,'Out of Stock'),
       ('O+',0,NULL,'Out of Stock'),('O-',0,NULL,'Out of Stock')
ON DUPLICATE KEY UPDATE blood_group = VALUES(blood_group);

-- Default admin: username=admin
-- IMPORTANT: replace the hash below with a real BCrypt hash before running this file.
-- Generate one in Java: new BCryptPasswordEncoder().encode("admin123")
-- or via https://bcrypt-generator.com (cost factor 10) and paste the result here.
INSERT INTO admins (username, password, full_name, role)
VALUES ('admin', '$2a$10$REPLACE.WITH.A.REAL.BCRYPT.HASH.FOR.admin123xxxxxxxxxx', 'Admin User', 'ADMIN')
ON DUPLICATE KEY UPDATE username = VALUES(username);
