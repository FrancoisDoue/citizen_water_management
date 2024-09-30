package com.citizen.water_management.repository.account;

import com.citizen.water_management.entity.account.Account;
import com.citizen.water_management.entity.account.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByEmail(String email);

    List<Account> findAllByRole(Role role);
}
