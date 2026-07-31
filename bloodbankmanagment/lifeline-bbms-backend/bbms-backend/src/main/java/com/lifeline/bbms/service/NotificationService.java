package com.lifeline.bbms.service;

import com.lifeline.bbms.entity.WaitingQueueEntry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Sends an email (and, optionally, an SMS via a third-party gateway you wire
 * up here) when a waiting request is fulfilled because stock became available.
 * Wrapped in try/catch so a misconfigured mail server never breaks the
 * core CRUD/queue flow.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final JavaMailSender mailSender;

    public void notifyBloodAvailable(WaitingQueueEntry entry) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("Blood Available: " + entry.getBloodGroup());
            message.setText("Good news — " + entry.getUnitsRequired() + " unit(s) of " + entry.getBloodGroup()
                    + " requested for " + entry.getPatientName() + " are now available and have been issued.");
            // message.setTo(patientOrDonorEmailLookup(entry.getPatientId()));
            mailSender.send(message);
        } catch (Exception e) {
            log.warn("Email notification failed (non-fatal): {}", e.getMessage());
        }
    }

    public void sendSms(String phone, String text) {
        // Plug in an SMS gateway (Twilio, MSG91, etc.) here. Left as a stub.
        log.info("[SMS to {}] {}", phone, text);
    }
}
