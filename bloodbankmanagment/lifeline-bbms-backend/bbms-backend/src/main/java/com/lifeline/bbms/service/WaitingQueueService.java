package com.lifeline.bbms.service;

import com.lifeline.bbms.entity.WaitingQueueEntry;
import com.lifeline.bbms.repository.WaitingQueueRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.UUID;

/**
 * Backs the Waiting Queue module with a real FIFO java.util.ArrayDeque.
 * When blood is unavailable for a request, it is enqueued here. When stock
 * for a group is replenished, InventoryService/BloodRequestService call
 * processAvailable() to dequeue and fulfil the oldest matching request(s)
 * first — true First-In-First-Out behaviour.
 */
@Service
@RequiredArgsConstructor
public class WaitingQueueService {

    private final WaitingQueueRepository waitingQueueRepository;
    private final InventoryService inventoryService;
    private final NotificationService notificationService;

    private final Deque<WaitingQueueEntry> queue = new ArrayDeque<>();

    @PostConstruct
    public void loadQueue() {
        queue.addAll(waitingQueueRepository.findByStatusOrderByQueuedAtAsc("Waiting"));
    }

    public synchronized WaitingQueueEntry enqueue(Long patientId, String patientName, String bloodGroup, int units) {
        WaitingQueueEntry entry = WaitingQueueEntry.builder()
                .queueCode("W" + UUID.randomUUID().toString().substring(0, 8).toUpperCase())
                .patientId(patientId).patientName(patientName)
                .bloodGroup(bloodGroup).unitsRequired(units)
                .status("Waiting")
                .build();
        entry = waitingQueueRepository.save(entry);
        queue.addLast(entry); // enqueue at the back — FIFO
        return entry;
    }

    public synchronized List<WaitingQueueEntry> view() {
        return List.copyOf(queue);
    }

    /**
     * Walks the queue from the front (oldest first) and fulfils every request
     * for {@code bloodGroup} that current stock can satisfy, dequeuing each
     * as it's processed. Returns how many were fulfilled.
     */
    public synchronized int processAvailable(String bloodGroup) {
        int processed = 0;
        Deque<WaitingQueueEntry> remaining = new ArrayDeque<>();
        while (!queue.isEmpty()) {
            WaitingQueueEntry entry = queue.pollFirst(); // dequeue oldest
            if (entry.getBloodGroup().equals(bloodGroup) && inventoryService.hasStock(bloodGroup, entry.getUnitsRequired())) {
                inventoryService.tryIssue(bloodGroup, entry.getUnitsRequired());
                entry.setStatus("Fulfilled");
                entry.setFulfilledAt(LocalDateTime.now());
                waitingQueueRepository.save(entry);
                if (notificationService != null) notificationService.notifyBloodAvailable(entry);
                processed++;
            } else {
                remaining.addLast(entry); // put back, preserving original order
            }
        }
        queue.addAll(remaining);
        return processed;
    }
}
