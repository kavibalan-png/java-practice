package com.lifeline.bbms.repository;

import com.lifeline.bbms.entity.EmergencyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmergencyRequestRepository extends JpaRepository<EmergencyRequest, Long> {
    // Backs the PriorityQueue: highest priority weight first, oldest first within same weight
    List<EmergencyRequest> findByStatusOrderByPriorityWeightDescCreatedAtAsc(String status);
}
