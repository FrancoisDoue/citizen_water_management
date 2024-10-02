package com.citizen.water_management.repository;

import com.citizen.water_management.entity.account.Account;
import com.citizen.water_management.entity.location.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {
    Optional <Home> findFirstByAccounts(List<Account> accounts);
}
