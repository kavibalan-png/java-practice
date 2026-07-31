package com.lifeline.bbms.service;

import com.lifeline.bbms.entity.BloodRequest;
import com.lifeline.bbms.repository.BloodRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Implements the core Blood Request workflow described in the spec:
 * select group -> enter units -> check availability (HashMap lookup) ->
 * issue & update inventory, OR add to the FIFO waiting queue.
 */
@Service
@RequiredArgsConstructor
public class BloodRequestService {

    private final BloodRequestRepository bloodRequestRepository;
    private final InventoryService inventoryService;
    private final WaitingQueueService waitingQueueService;

    public List<BloodRequest> findAll() { return bloodRequestRepository.findAllByOrderByRequestDateDesc(); }

    public synchronized BloodRequest submit(Long patientId, String patientName, String bloodGroup, int units) {
        BloodRequest request = BloodRequest.builder()
                .requestCode("R" + UUID.randomUUID().toString().substring(0, 8).toUpperCase())
                .patientId(patientId).patientName(patientName)
                .bloodGroup(bloodGroup).unitsRequested(units)
                .build();

        if (inventoryService.tryIssue(bloodGroup, units)) {
            request.setStatus("Issued");
            request.setResolvedDate(LocalDateTime.now());
        } else {
            request.setStatus("Waiting");
            waitingQueueService.enqueue(patientId, patientName, bloodGroup, units);
        }
        return bloodRequestRepository.save(request);
    }

    /** Call after adding stock to auto-process any matching waiting requests, oldest first. */
    public int processQueueAfterRestock(String bloodGroup) {
        return waitingQueueService.processAvailable(bloodGroup);
    }
}
