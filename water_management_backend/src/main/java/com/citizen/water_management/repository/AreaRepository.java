package com.citizen.water_management.repository;

import com.citizen.water_management.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
    Optional<Area> findByName(String name);
    Optional<Area> findByReference(String reference);
}
