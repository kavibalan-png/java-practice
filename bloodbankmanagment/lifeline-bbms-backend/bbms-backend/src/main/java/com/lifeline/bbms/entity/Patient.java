package com.lifeline.bbms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "patients")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_code", nullable = false, unique = true)
    private String patientCode;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String hospital;

    @Column(name = "blood_group_required", nullable = false, length = 3)
    private String bloodGroupRequired;

    @Column(name = "units_required", nullable = false)
    private Integer unitsRequired;

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name = "priority_level")
    private String priorityLevel; // Critical / High / Medium / Normal

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (priorityLevel == null) priorityLevel = "Normal";
    }

    @PreUpdate
    void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
