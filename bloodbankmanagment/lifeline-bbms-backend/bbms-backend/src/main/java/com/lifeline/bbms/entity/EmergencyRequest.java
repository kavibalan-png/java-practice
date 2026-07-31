package com.lifeline.bbms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "emergency_requests")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EmergencyRequest {

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

    @Column(name = "units_required", nullable = false)
    private Integer unitsRequired;

    @Column(name = "priority_level", nullable = false)
    private String priorityLevel; // Critical / High / Medium / Normal

    @Column(name = "priority_weight", nullable = false)
    private Integer priorityWeight; // Critical=4 High=3 Medium=2 Normal=1

    private String status; // Queued / Processed / Escalated

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "processed_at")
    private LocalDateTime processedAt;

    @PrePersist
    void prePersist() {
        createdAt = LocalDateTime.now();
        if (status == null) status = "Queued";
    }
}
