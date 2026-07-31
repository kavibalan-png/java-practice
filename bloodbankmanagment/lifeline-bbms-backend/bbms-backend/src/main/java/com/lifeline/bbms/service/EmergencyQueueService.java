package com.lifeline.bbms.service;

import com.lifeline.bbms.entity.EmergencyRequest;
import com.lifeline.bbms.repository.EmergencyRequestRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.UUID;

/**
 * Backs the Emergency Requests module with a real java.util.PriorityQueue.
 * Ordering: higher priority weight first (Critical=4 ... Normal=1), and for
 * requests of equal priority, the one that arrived earlier (FIFO tie-break).
 * The queue is rebuilt from the database on startup and every request is
 * persisted so the queue survives restarts.
 */
@Service
@RequiredArgsConstructor
public class EmergencyQueueService {

    private static final Comparator<EmergencyRequest> ORDER =
            Comparator.comparingInt(EmergencyRequest::getPriorityWeight).reversed()
                    .thenComparing(EmergencyRequest::getCreatedAt);

    private final EmergencyRequestRepository emergencyRequestRepository;
    private final InventoryService inventoryService;
    private final WaitingQueueService waitingQueueService;

    private final PriorityQueue<EmergencyRequest> queue = new PriorityQueue<>(ORDER);

    public static int weightOf(String priority) {
        return switch (priority) {
            case "Critical" -> 4;
            case "High" -> 3;
            case "Medium" -> 2;
            default -> 1;
        };
    }

    @PostConstruct
    public void loadQueue() {
        queue.addAll(emergencyRequestRepository.findByStatusOrderByPriorityWeightDescCreatedAtAsc("Queued"));
    }

    public synchronized EmergencyRequest enqueue(Long patientId, String patientName, String bloodGroup,
                                                  int units, String priority) {
        EmergencyRequest req = EmergencyRequest.builder()
                .requestCode("E" + UUID.randomUUID().toString().substring(0, 8).toUpperCase())
                .patientId(patientId).patientName(patientName)
                .bloodGroup(bloodGroup).unitsRequired(units)
                .priorityLevel(priority).priorityWeight(weightOf(priority))
                .status("Queued")
                .build();
        req = emergencyRequestRepository.save(req);
        queue.add(req);
        return req;
    }

    /** Returns the current queue ordered by priority without removing anything (peek all). */
    public synchronized List<EmergencyRequest> viewOrdered() {
        return queue.stream().sorted(ORDER).toList();
    }

    /** Dequeues (removes) the single highest-priority request and attempts to fulfil it. */
    public synchronized EmergencyRequest processNext() {
        EmergencyRequest top = queue.poll(); // O(log n) dequeue of the highest priority item
        if (top == null) return null;
        fulfilOrQueue(top);
        return top;
    }

    public synchronized EmergencyRequest processById(Long id) {
        EmergencyRequest target = queue.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
        if (target == null) return null;
        queue.remove(target);
        fulfilOrQueue(target);
        return target;
    }

    private void fulfilOrQueue(EmergencyRequest req) {
        if (inventoryService.tryIssue(req.getBloodGroup(), req.getUnitsRequired())) {
            req.setStatus("Processed");
            req.setProcessedAt(LocalDateTime.now());
        } else {
            req.setStatus("Escalated");
            waitingQueueService.enqueue(req.getPatientId(), req.getPatientName(), req.getBloodGroup(), req.getUnitsRequired());
        }
        emergencyRequestRepository.save(req);
    }
}
