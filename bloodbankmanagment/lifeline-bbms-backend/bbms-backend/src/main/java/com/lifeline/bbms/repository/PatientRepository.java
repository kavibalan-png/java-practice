package com.lifeline.bbms.repository;

import com.lifeline.bbms.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByPatientCode(String patientCode);
    List<Patient> findByPriorityLevel(String priorityLevel);
    List<Patient> findByNameContainingIgnoreCaseOrHospitalContainingIgnoreCase(String name, String hospital);
}
