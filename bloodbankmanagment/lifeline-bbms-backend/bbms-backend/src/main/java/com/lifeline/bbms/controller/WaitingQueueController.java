package com.lifeline.bbms.controller;

import com.lifeline.bbms.entity.WaitingQueueEntry;
import com.lifeline.bbms.service.WaitingQueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waiting-queue")
@RequiredArgsConstructor
public class WaitingQueueController {

    private final WaitingQueueService waitingQueueService;

    /** FIFO view — oldest request first. */
    @GetMapping
    public List<WaitingQueueEntry> queue() { return waitingQueueService.view(); }
}
