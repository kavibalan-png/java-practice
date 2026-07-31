package com.lifeline.bbms.service;

import com.lifeline.bbms.entity.Patient;
import com.lifeline.bbms.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public List<Patient> findAll() { return patientRepository.findAll(); }

    public Patient findById(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found: " + id));
    }

    public List<Patient> search(String query) {
        if (query == null || query.isBlank()) return patientRepository.findAll();
        return patientRepository.findByNameContainingIgnoreCaseOrHospitalContainingIgnoreCase(query, query);
    }

    public Patient register(Patient patient) {
        patient.setId(null);
        patient.setPatientCode("P" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        if (patient.getPriorityLevel() == null) patient.setPriorityLevel("Normal");
        return patientRepository.save(patient);
    }

    public Patient update(Long id, Patient updated) {
        Patient existing = findById(id);
        existing.setName(updated.getName());
        existing.setHospital(updated.getHospital());
        existing.setBloodGroupRequired(updated.getBloodGroupRequired());
        existing.setUnitsRequired(updated.getUnitsRequired());
        existing.setDoctorName(updated.getDoctorName());
        existing.setPriorityLevel(updated.getPriorityLevel());
        return patientRepository.save(existing);
    }

    public void delete(Long id) { patientRepository.deleteById(id); }
}
