package com.citizen.water_management.controller;

import com.citizen.water_management.dto.alert.AlertDtoGet;
import com.citizen.water_management.dto.alert.AlertDtoPost;
import com.citizen.water_management.services.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/municipal-technician")
public class MunicipalTechnician {

    @Autowired
    private AlertService alertService;


    @PostMapping("/alert/add")
    public ResponseEntity<AlertDtoGet> addAlert(@RequestBody AlertDtoPost alertDtoPost) {
        return ResponseEntity.ok(alertService.addAlert(alertDtoPost));
    }
}
