package com.citizen.water_management.controller;

import com.citizen.water_management.dto.alert.AlertDtoGet;
import com.citizen.water_management.dto.alert.AlertDtoPost;
import com.citizen.water_management.services.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/municipal-technician")
public class MunicipalTechnicianController {

    @Autowired
    private AlertService alertService;


    @PostMapping("/alert/add")
    public ResponseEntity<AlertDtoGet> addAlert(@RequestBody AlertDtoPost alertDtoPost) {
        return ResponseEntity.ok(alertService.addAlert(alertDtoPost));
    }

    @GetMapping("/alert/green-space-alert")
    public ResponseEntity<List<AlertDtoGet>> getAlertGreenSpaceAlert() {
        return ResponseEntity.ok(alertService.getAllAlertsWhereIsGreenSpace());
    }

}
