package com.lifeline.bbms.dto;

import lombok.Data;

@Data
public class BloodRequestDto {
    private Long patientId;
    private String patientName;
    private String bloodGroup;
    private int units;
}
