package com.citizen.water_management.dto.notification;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NotificationDtoPost {

    private String title;
    private String imageUrl;
    private String message;
    private int accountId;
}
