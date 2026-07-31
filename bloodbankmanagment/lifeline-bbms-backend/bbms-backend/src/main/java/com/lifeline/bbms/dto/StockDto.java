package com.lifeline.bbms.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class StockDto {
    private String bloodGroup;
    private int units;
    private LocalDate expiryDate;
}
