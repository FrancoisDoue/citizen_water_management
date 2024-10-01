package com.citizen.water_management.repository;

import com.citizen.water_management.entity.WaterSupply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterSupplyRepository extends JpaRepository<WaterSupply, Long> {
}
