package com.lifeline.bbms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "blood_requests")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BloodRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "request_code", nullable = false, unique = true)
    private String requestCode;

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "blood_group", nullable = false, length = 3)
    private String bloodGroup;

    @Column(name = "units_requested", nullable = false)
    private Integer unitsRequested;

    private String status; // Pending / Issued / Waiting / Rejected

    @Column(name = "request_date")
    private LocalDateTime requestDate;

    @Column(name = "resolved_date")
    private LocalDateTime resolvedDate;

    @PrePersist
    void prePersist() {
        requestDate = LocalDateTime.now();
        if (status == null) status = "Pending";
    }
}
