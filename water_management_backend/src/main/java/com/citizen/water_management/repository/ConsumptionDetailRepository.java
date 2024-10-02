package com.citizen.water_management.repository;

import com.citizen.water_management.entity.ConsumptionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumptionDetailRepository extends JpaRepository<ConsumptionDetail, Long> {
}
