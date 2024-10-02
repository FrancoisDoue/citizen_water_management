package com.citizen.water_management.controller;

import com.citizen.water_management.dto.notification.NotificationDtoGet;
import com.citizen.water_management.services.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final NotificationService notificationService;

    public UserController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/{userID}/notification")
    public ResponseEntity<List<NotificationDtoGet>> getNotificationsByUser(@PathVariable("userID") int userID) {
        return ResponseEntity.ok(notificationService.getAllNotificationsByAccountId(userID));
    }
}
