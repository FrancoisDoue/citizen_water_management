package com.citizen.water_management.controller;

import com.citizen.water_management.dto.account.LoginDTO;
import com.citizen.water_management.dto.account.RegisterDTO;
import com.citizen.water_management.entity.account.Account;
import com.citizen.water_management.entity.account.Role;
import com.citizen.water_management.services.AuthenticationService;
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

    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody RegisterDTO newAccount) {
        Account account = authenticationService.registerAccount(
                Account.builder()
                    .email(newAccount.getEmail())
                    .password(newAccount.getPassword())
                    .firstname(newAccount.getFirstname())
                    .lastname(newAccount.getLastname())
                    .build(),
                Role.builder().authority(newAccount.getRole()).build()
        );
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }
}
