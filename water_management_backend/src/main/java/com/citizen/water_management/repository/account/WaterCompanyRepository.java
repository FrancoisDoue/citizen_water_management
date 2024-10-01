package com.citizen.water_management.repository.account;

import com.citizen.water_management.entity.account.WaterCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaterCompanyRepository extends JpaRepository<WaterCompany, Integer> {
}
