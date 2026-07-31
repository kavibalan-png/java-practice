package com.lifeline.bbms.controller;

import com.lifeline.bbms.entity.BloodRequest;
import com.lifeline.bbms.entity.EmergencyRequest;
import com.lifeline.bbms.repository.BloodRequestRepository;
import com.lifeline.bbms.service.EmergencyQueueService;
import com.lifeline.bbms.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final BloodRequestRepository bloodRequestRepository;
    private final EmergencyQueueService emergencyQueueService;
    private final InventoryService inventoryService;

    @GetMapping("/usage")
    public Map<String, Long> bloodUsageByGroup() {
        return bloodRequestRepository.findAll().stream()
                .filter(r -> "Issued".equalsIgnoreCase(r.getStatus()))
                .collect(Collectors.groupingBy(BloodRequest::getBloodGroup, Collectors.counting()));
    }

    @GetMapping("/top-groups")
    public List<Map.Entry<String, Long>> topGroupsRequested() {
        Map<String, Long> counts = bloodRequestRepository.findAll().stream()
                .collect(Collectors.groupingBy(BloodRequest::getBloodGroup, Collectors.counting()));
        return counts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .toList();
    }

    @GetMapping("/emergency-cases")
    public List<EmergencyRequest> emergencyCases() { return emergencyQueueService.viewOrdered(); }

    @GetMapping("/low-stock")
    public List<String> lowStock() { return inventoryService.lowStockGroups(); }

    @GetMapping("/out-of-stock")
    public List<String> outOfStock() { return inventoryService.outOfStockGroups(); }
}
