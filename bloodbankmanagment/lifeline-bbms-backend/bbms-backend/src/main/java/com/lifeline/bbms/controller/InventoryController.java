package com.lifeline.bbms.controller;

import com.lifeline.bbms.dto.StockDto;
import com.lifeline.bbms.entity.BloodUnit;
import com.lifeline.bbms.service.BloodRequestService;
import com.lifeline.bbms.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;
    private final BloodRequestService bloodRequestService;

    @GetMapping
    public Map<String, BloodUnit> all() { return inventoryService.getAllAvailability(); }

    /** O(1) HashMap lookup backing the Availability Search module. */
    @GetMapping("/{bloodGroup}")
    public BloodUnit lookup(@PathVariable String bloodGroup) { return inventoryService.getAvailability(bloodGroup); }

    @PostMapping("/add-stock")
    public BloodUnit addStock(@RequestBody StockDto dto) {
        BloodUnit unit = inventoryService.addStock(dto.getBloodGroup(), dto.getUnits(), dto.getExpiryDate());
        bloodRequestService.processQueueAfterRestock(dto.getBloodGroup()); // auto-drain matching waiting requests, oldest first
        return unit;
    }
}
