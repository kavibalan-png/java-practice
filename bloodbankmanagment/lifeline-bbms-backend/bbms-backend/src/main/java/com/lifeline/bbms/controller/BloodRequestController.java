package com.lifeline.bbms.controller;

import com.lifeline.bbms.dto.BloodRequestDto;
import com.lifeline.bbms.entity.BloodRequest;
import com.lifeline.bbms.service.BloodRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blood-requests")
@RequiredArgsConstructor
public class BloodRequestController {

    private final BloodRequestService bloodRequestService;

    @GetMapping
    public List<BloodRequest> all() { return bloodRequestService.findAll(); }

    /** Check availability and either issue blood or queue the request (FIFO). */
    @PostMapping
    public BloodRequest submit(@RequestBody BloodRequestDto dto) {
        return bloodRequestService.submit(dto.getPatientId(), dto.getPatientName(), dto.getBloodGroup(), dto.getUnits());
    }
}
