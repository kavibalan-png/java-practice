package com.lifeline.bbms.service;

import com.lifeline.bbms.entity.Donor;
import com.lifeline.bbms.repository.DonorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DonorService {

    private final DonorRepository donorRepository;

    public List<Donor> findAll() { return donorRepository.findAll(); }

    public Donor findById(Long id) {
        return donorRepository.findById(id).orElseThrow(() -> new RuntimeException("Donor not found: " + id));
    }

    public List<Donor> search(String name, String bloodGroup) {
        if (name != null && !name.isBlank() && bloodGroup != null && !bloodGroup.isBlank()) {
            return donorRepository.findByNameContainingIgnoreCaseAndBloodGroup(name, bloodGroup);
        } else if (name != null && !name.isBlank()) {
            return donorRepository.findByNameContainingIgnoreCase(name);
        } else if (bloodGroup != null && !bloodGroup.isBlank()) {
            return donorRepository.findByBloodGroup(bloodGroup);
        }
        return donorRepository.findAll();
    }

    public Donor register(Donor donor) {
        donor.setId(null);
        donor.setDonorCode("D" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        if (donor.getEligibilityStatus() == null) donor.setEligibilityStatus("Eligible");
        return donorRepository.save(donor);
    }

    public Donor update(Long id, Donor updated) {
        Donor existing = findById(id);
        existing.setName(updated.getName());
        existing.setAge(updated.getAge());
        existing.setGender(updated.getGender());
        existing.setBloodGroup(updated.getBloodGroup());
        existing.setPhone(updated.getPhone());
        existing.setAddress(updated.getAddress());
        existing.setLastDonationDate(updated.getLastDonationDate());
        existing.setEligibilityStatus(updated.getEligibilityStatus());
        return donorRepository.save(existing);
    }

    public void delete(Long id) { donorRepository.deleteById(id); }
}
