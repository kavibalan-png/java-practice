package com.lifeline.bbms.controller;

import com.lifeline.bbms.entity.Patient;
import com.lifeline.bbms.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public List<Patient> all(@RequestParam(required = false) String query) {
        return query != null ? patientService.search(query) : patientService.findAll();
    }

    @GetMapping("/{id}")
    public Patient get(@PathVariable Long id) { return patientService.findById(id); }

    @PostMapping
    public Patient create(@RequestBody Patient patient) { return patientService.register(patient); }

    @PutMapping("/{id}")
    public Patient update(@PathVariable Long id, @RequestBody Patient patient) { return patientService.update(id, patient); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { patientService.delete(id); }
}
