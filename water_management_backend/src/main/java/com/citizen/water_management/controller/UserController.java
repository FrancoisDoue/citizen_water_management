package com.citizen.water_management.controller;

import com.citizen.water_management.dto.notification.NotificationDtoGet;
import com.citizen.water_management.dto.waterSupply.WaterSupplyDtoGetForHistoryOfConsumption;
import com.citizen.water_management.entity.account.Account;
import com.citizen.water_management.services.AdministratorActionService;
import com.citizen.water_management.services.LocationService;
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
    private final LocationService locationService;
    private final AdministratorActionService administratorActionService;

    public UserController(NotificationService notificationService,
                          LocationService locationService,
                          AdministratorActionService administratorActionService) {
        this.notificationService = notificationService;
        this.locationService = locationService;
        this.administratorActionService = administratorActionService;
    }

    @GetMapping("/{userID}/notification")
    public ResponseEntity<List<NotificationDtoGet>> getNotificationsByUser(@PathVariable("userID") int userID) {
        return ResponseEntity.ok(notificationService.getAllNotificationsByAccountId(userID));
    }

    @GetMapping("/{userId}/history-of-consumption")
    public ResponseEntity<List<WaterSupplyDtoGetForHistoryOfConsumption>>
    getHistoryOfConsumptionByUser(@PathVariable("userId") int userId) {
        return ResponseEntity.ok(locationService.getHistoryOfConsumptions(userId));
    }

    @GetMapping("/{userId}/consumption-of-last-month")
    public ResponseEntity<List<WaterSupplyDtoGetForHistoryOfConsumption>>
    getConsumptionOfLastMonth(@PathVariable("userId") int userId) {
        return ResponseEntity.ok(locationService.getLastConsumptions(userId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Account> getAccountByUser(@PathVariable("userId") int userId) {
        return ResponseEntity.ok(administratorActionService.getAccountById(userId));
    }
}
