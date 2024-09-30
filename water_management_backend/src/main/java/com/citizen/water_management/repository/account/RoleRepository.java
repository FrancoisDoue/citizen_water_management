package com.citizen.water_management.repository.account;

import com.citizen.water_management.entity.account.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByAuthority(String authority);

    Boolean existsByAuthority(String authority);
}
