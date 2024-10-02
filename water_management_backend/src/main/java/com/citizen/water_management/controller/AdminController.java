package com.citizen.water_management.controller;

import com.citizen.water_management.entity.Alert;
import com.citizen.water_management.entity.account.Account;
import com.citizen.water_management.entity.account.Role;
import com.citizen.water_management.services.AdministratorActionService;
import com.citizen.water_management.services.AlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdministratorActionService administratorActionService;
    private final AlertService alertService;

    public AdminController(AdministratorActionService administratorActionService, AlertService alertService) {
        this.administratorActionService = administratorActionService;
        this.alertService = alertService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAccounts(@RequestParam(required = false, name = "role") String role) {
        if (role != null && !role.isEmpty())
            return ResponseEntity.ok(administratorActionService.getAccountsByRole(role));
        return ResponseEntity.ok(administratorActionService.getAllAccounts());
    }

    @PutMapping("/accounts/{id}/{role}")
    public ResponseEntity<Account> setRoleToAccount(@PathVariable(name = "id") int id, @PathVariable(name = "role") String role) {
        return ResponseEntity.ok(administratorActionService.setRoleToAccount(id, role));
    }

    @GetMapping("/alerts")
    public ResponseEntity<List<Alert>> getAlerts(@RequestParam(required = false, name = "open") Boolean open) {
        return ResponseEntity.ok(administratorActionService.getAllAlerts(open));
    }
}
