package com.lifeline.bbms.repository;

import com.lifeline.bbms.entity.BloodUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BloodUnitRepository extends JpaRepository<BloodUnit, Long> {
    Optional<BloodUnit> findByBloodGroup(String bloodGroup);
}
