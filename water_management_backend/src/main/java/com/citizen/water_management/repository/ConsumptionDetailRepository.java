package com.citizen.water_management.repository;

import com.citizen.water_management.entity.ConsumptionDetail;
import com.citizen.water_management.entity.WaterSupply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumptionDetailRepository extends JpaRepository<ConsumptionDetail, Long> {

     ConsumptionDetail findFirstByWaterSupplyOrderByEndDateDesc(WaterSupply waterSupply);
}
