package com.citizen.water_management.dto.alert;

import lombok.Data;

@Data
public class AlertDtoPost {
    private String title;
    private String message;
    private long waterSupply;
}
