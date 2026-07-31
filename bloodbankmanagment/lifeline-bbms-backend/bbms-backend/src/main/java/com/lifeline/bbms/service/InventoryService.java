package com.lifeline.bbms.service;

import com.lifeline.bbms.entity.BloodUnit;
import com.lifeline.bbms.repository.BloodUnitRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Maintains an in-memory HashMap<bloodGroup, BloodUnit> cache mirroring the
 * blood_units table, giving O(1) average-time availability lookups instead of
 * hitting the database on every request. The DB row is still the source of
 * truth and is updated alongside the cache on every mutation.
 */
@Service
@RequiredArgsConstructor
public class InventoryService {

    public static final String[] GROUPS = {"A+","A-","B+","B-","AB+","AB-","O+","O-"};

    private final BloodUnitRepository bloodUnitRepository;

    // The HashMap that gives O(1) lookups by blood group
    private final Map<String, BloodUnit> stockMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void loadCache() {
        for (String g : GROUPS) {
            BloodUnit unit = bloodUnitRepository.findByBloodGroup(g)
                    .orElseGet(() -> bloodUnitRepository.save(
                            BloodUnit.builder().bloodGroup(g).unitsAvailable(0).storageStatus("Out of Stock").build()));
            stockMap.put(g, unit);
        }
    }

    /** O(1) HashMap lookup used by the Availability Search module. */
    public BloodUnit getAvailability(String bloodGroup) {
        return stockMap.get(bloodGroup);
    }

    public Map<String, BloodUnit> getAllAvailability() {
        // preserve canonical group order
        Map<String, BloodUnit> ordered = new LinkedHashMap<>();
        for (String g : GROUPS) ordered.put(g, stockMap.get(g));
        return ordered;
    }

    public synchronized BloodUnit addStock(String bloodGroup, int units, LocalDate expiry) {
        BloodUnit unit = stockMap.get(bloodGroup);
        unit.setUnitsAvailable(unit.getUnitsAvailable() + units);
        if (expiry != null) unit.setExpiryDate(expiry);
        refreshStatus(unit);
        bloodUnitRepository.save(unit);
        return unit;
    }

    /** Returns true and deducts stock if enough units are available; false otherwise (nothing is deducted). */
    public synchronized boolean tryIssue(String bloodGroup, int units) {
        BloodUnit unit = stockMap.get(bloodGroup);
        if (unit.getUnitsAvailable() < units) return false;
        unit.setUnitsAvailable(unit.getUnitsAvailable() - units);
        refreshStatus(unit);
        bloodUnitRepository.save(unit);
        return true;
    }

    public boolean hasStock(String bloodGroup, int units) {
        BloodUnit unit = stockMap.get(bloodGroup);
        return unit != null && unit.getUnitsAvailable() >= units;
    }

    public List<String> outOfStockGroups() {
        return stockMap.values().stream()
                .filter(u -> u.getUnitsAvailable() == 0)
                .map(BloodUnit::getBloodGroup)
                .toList();
    }

    public List<String> lowStockGroups() {
        return stockMap.values().stream()
                .filter(u -> u.getUnitsAvailable() > 0 && u.getUnitsAvailable() <= 10)
                .map(BloodUnit::getBloodGroup)
                .toList();
    }

    private void refreshStatus(BloodUnit unit) {
        int u = unit.getUnitsAvailable();
        unit.setStorageStatus(u == 0 ? "Out of Stock" : u <= 10 ? "Low Stock" : "In Stock");
    }
}
