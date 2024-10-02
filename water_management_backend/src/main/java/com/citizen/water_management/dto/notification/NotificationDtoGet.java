package com.citizen.water_management.dto.notification;

import com.citizen.water_management.entity.Notification;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class NotificationDtoGet {

    private long id;

    private String title;
    private String imageUrl;
    private String message;
    private boolean open;
    private LocalDateTime createdDate;

    public NotificationDtoGet(Notification notification) {
        this.id = notification.getId();
        this.title = notification.getTitle();
        this.imageUrl = notification.getImageUrl();
        this.message = notification.getMessage();
        this.open = notification.isOpen();
        this.createdDate = notification.getCreatedDate();
    }
}
