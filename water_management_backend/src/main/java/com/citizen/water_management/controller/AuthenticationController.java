package com.citizen.water_management.controller;

import com.citizen.water_management.dto.account.CompanyTechnicianRegisterDTO;
import com.citizen.water_management.dto.account.LoginDTO;
import com.citizen.water_management.dto.account.BaseRegisterDTO;
import com.citizen.water_management.dto.account.TechnicianRegisterDTO;
import com.citizen.water_management.entity.account.Account;
import com.citizen.water_management.entity.account.Role;
import com.citizen.water_management.entity.account.Technician;
import com.citizen.water_management.entity.account.WaterCompany;
import com.citizen.water_management.services.AuthenticationService;
import com.citizen.water_management.util.type.RoleType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")

public class AuthenticationController {

    private final AuthenticationService authenticationService;
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginDTO login) {
        authenticationService.login(login.getEmail(), login.getPassword());
        return ResponseEntity.ok(Map.of(
                "token", authenticationService.generateToken(login.getEmail(), login.getPassword())
        ));
    }

    @PostMapping("/register/user")
    public ResponseEntity<Account> register(@RequestBody BaseRegisterDTO newAccount) {
        Account account = authenticationService.registerAccount(
                Account.builder()
                    .email(newAccount.getEmail())
                    .password(newAccount.getPassword())
                    .firstname(newAccount.getFirstname())
                    .lastname(newAccount.getLastname())
                    .build(),
                Role.builder().authority(RoleType.USER.name()).build()
        );
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @PostMapping("/register/technician")
    public ResponseEntity<Technician> registerTechnician(@RequestBody TechnicianRegisterDTO newAccount) {
        Technician technician = (Technician) authenticationService.registerAccount(
                Technician.builder()
                        .email(newAccount.getEmail())
                        .password(newAccount.getPassword())
                        .firstname(newAccount.getFirstname())
                        .lastname(newAccount.getLastname())
                        .job(newAccount.getJob())
                        .build(),
                Role.builder().authority(RoleType.TECHNICIAN.name()).build()
        );
        return new ResponseEntity<>(technician, HttpStatus.CREATED);
    }

    @PostMapping("/register/company-technician")
    public ResponseEntity<Technician> registerCompanyTechnician(@RequestBody CompanyTechnicianRegisterDTO newAccount) {
        return new ResponseEntity<>(authenticationService.registerCompanyTechnicianAccount(newAccount), HttpStatus.CREATED);
    }

    @PostMapping("/register/company")
    public ResponseEntity<WaterCompany> registerCompany(@RequestBody BaseRegisterDTO newAccount) {
        WaterCompany waterCompany = (WaterCompany) authenticationService.registerAccount(
                WaterCompany.builder()
                        .email(newAccount.getEmail())
                        .password(newAccount.getPassword())
                        .firstname(newAccount.getFirstname())
                        .lastname(newAccount.getLastname())
                        .build(),
                Role.builder().authority(RoleType.WATER_COMPANY.name()).build()
        );
        return new ResponseEntity<>(waterCompany, HttpStatus.CREATED);
    }
}
