package com.lifeline.bbms.repository;

import com.lifeline.bbms.entity.WaitingQueueEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WaitingQueueRepository extends JpaRepository<WaitingQueueEntry, Long> {
    // Backs the FIFO Queue: oldest queued_at first
    List<WaitingQueueEntry> findByStatusOrderByQueuedAtAsc(String status);
    List<WaitingQueueEntry> findByBloodGroupAndStatusOrderByQueuedAtAsc(String bloodGroup, String status);
}
