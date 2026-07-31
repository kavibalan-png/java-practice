package com.lifeline.bbms.repository;

import com.lifeline.bbms.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface DonorRepository extends JpaRepository<Donor, Long> {
    Optional<Donor> findByDonorCode(String donorCode);
    List<Donor> findByBloodGroup(String bloodGroup);
    List<Donor> findByNameContainingIgnoreCase(String name);
    List<Donor> findByNameContainingIgnoreCaseAndBloodGroup(String name, String bloodGroup);
}
