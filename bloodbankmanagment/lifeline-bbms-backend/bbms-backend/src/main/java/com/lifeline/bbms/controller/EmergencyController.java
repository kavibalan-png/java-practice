package com.lifeline.bbms.controller;

import com.lifeline.bbms.dto.EmergencyRequestDto;
import com.lifeline.bbms.entity.EmergencyRequest;
import com.lifeline.bbms.service.EmergencyQueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emergency")
@RequiredArgsConstructor
public class EmergencyController {

    private final EmergencyQueueService emergencyQueueService;

    /** Priority-queue view, Critical first, regardless of arrival order. */
    @GetMapping
    public List<EmergencyRequest> queue() { return emergencyQueueService.viewOrdered(); }

    @PostMapping
    public EmergencyRequest add(@RequestBody EmergencyRequestDto dto) {
        return emergencyQueueService.enqueue(dto.getPatientId(), dto.getPatientName(), dto.getBloodGroup(),
                dto.getUnits(), dto.getPriority());
    }

    @PostMapping("/process-next")
    public EmergencyRequest processNext() { return emergencyQueueService.processNext(); }

    @PostMapping("/{id}/process")
    public EmergencyRequest processOne(@PathVariable Long id) { return emergencyQueueService.processById(id); }
}
