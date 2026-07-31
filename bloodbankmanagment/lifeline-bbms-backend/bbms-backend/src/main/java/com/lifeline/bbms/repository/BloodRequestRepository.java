package com.lifeline.bbms.repository;

import com.lifeline.bbms.entity.BloodRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BloodRequestRepository extends JpaRepository<BloodRequest, Long> {
    List<BloodRequest> findByStatus(String status);
    List<BloodRequest> findByBloodGroup(String bloodGroup);
    List<BloodRequest> findAllByOrderByRequestDateDesc();
}
