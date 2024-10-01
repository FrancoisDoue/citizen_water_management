package com.citizen.water_management.repository;

import com.citizen.water_management.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findByOpen(boolean isOpen);
}
