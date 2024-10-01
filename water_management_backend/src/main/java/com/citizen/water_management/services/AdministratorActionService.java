package com.citizen.water_management.services;

import com.citizen.water_management.entity.Alert;
import com.citizen.water_management.entity.account.Account;
import com.citizen.water_management.entity.account.Role;
import com.citizen.water_management.repository.AlertRepository;
import com.citizen.water_management.repository.account.AccountRepository;
import com.citizen.water_management.repository.account.RoleRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdministratorActionService {

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final AlertRepository alertRepository;

    public AdministratorActionService(AccountRepository accountRepository, RoleRepository roleRepository, AlertRepository alertRepository) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
        this.alertRepository = alertRepository;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public List<Account> getAccountsByRole(String role) {
        try {
            Integer roleId = Integer.parseInt(role);
            return accountRepository.findAllByRole(roleRepository.findById(roleId).orElse(null));
        } catch (NumberFormatException e) {
            return accountRepository.findAllByRole(roleRepository.findByAuthority(role).orElse(null));
        }
    }

    public Account setRoleToAccount(Integer id, String role) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Account not found with id: " + id));
        try {
            account.setRole(roleRepository.findById(Integer.parseInt(role)).orElseThrow(() -> new UsernameNotFoundException("Role not found with id: " + role)));
        } catch (NumberFormatException e) {
            account.setRole(roleRepository.findByAuthority(role).orElse(Role.builder().authority(role).build()));
        }
        return accountRepository.save(account);
    }

    public List<Alert> getAllAlerts(Boolean isOpen) {
        if (isOpen != null)
            return alertRepository.findByOpen(isOpen);
        return alertRepository.findAll();
    }

}
