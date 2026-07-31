package com.lifeline.bbms.dto;

import lombok.Data;

@Data
public class EmergencyRequestDto {
    private Long patientId;
    private String patientName;
    private String bloodGroup;
    private int units;
    private String priority; // Critical / High / Medium / Normal
}
