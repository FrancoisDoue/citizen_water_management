package com.citizen.water_management.repository;

import com.citizen.water_management.entity.account.Account;
import com.citizen.water_management.entity.location.Home;
import com.citizen.water_management.entity.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
