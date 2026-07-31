package com.lifeline.bbms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "blood_units")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BloodUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "blood_group", nullable = false, unique = true, length = 3)
    private String bloodGroup;

    @Column(name = "units_available", nullable = false)
    private Integer unitsAvailable;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "storage_status")
    private String storageStatus; // In Stock / Low Stock / Out of Stock

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @PreUpdate
    @PrePersist
    void touch() {
        lastUpdated = LocalDateTime.now();
        if (unitsAvailable == null) unitsAvailable = 0;
        storageStatus = unitsAvailable == 0 ? "Out of Stock" : unitsAvailable <= 10 ? "Low Stock" : "In Stock";
    }
}
