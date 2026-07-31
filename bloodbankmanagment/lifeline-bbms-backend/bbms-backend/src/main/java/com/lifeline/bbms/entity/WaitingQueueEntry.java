package com.lifeline.bbms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "waiting_queue")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class WaitingQueueEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "queue_code", nullable = false, unique = true)
    private String queueCode;

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "blood_group", nullable = false, length = 3)
    private String bloodGroup;

    @Column(name = "units_required", nullable = false)
    private Integer unitsRequired;

    @Column(name = "queued_at")
    private LocalDateTime queuedAt; // drives FIFO order

    private String status; // Waiting / Fulfilled / Cancelled

    @Column(name = "fulfilled_at")
    private LocalDateTime fulfilledAt;

    @PrePersist
    void prePersist() {
        queuedAt = LocalDateTime.now();
        if (status == null) status = "Waiting";
    }
}
