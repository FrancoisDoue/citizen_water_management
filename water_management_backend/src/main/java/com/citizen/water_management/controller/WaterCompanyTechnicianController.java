package com.citizen.water_management.controller;

import com.citizen.water_management.dto.alert.AlertDtoGet;
import com.citizen.water_management.dto.notification.NotificationDtoGet;
import com.citizen.water_management.dto.notification.NotificationDtoPost;
import com.citizen.water_management.services.AlertService;
import com.citizen.water_management.services.NotificationService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/water-company-technician")
public class WaterCompanyTechnicianController {

    @Autowired
    private AlertService alertService;
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/alert/all")
    public ResponseEntity<List<AlertDtoGet>> getAllAlerts() {
        return ResponseEntity.ok(alertService.getAllAlerts());
    }

    @PostMapping("/notification/add")
    public ResponseEntity<NotificationDtoGet> addNotification(@RequestBody NotificationDtoPost notificationDtoPost) {
        return ResponseEntity.status(Response.SC_CREATED)
                .body(notificationService.addNotification(notificationDtoPost));
    }
}
