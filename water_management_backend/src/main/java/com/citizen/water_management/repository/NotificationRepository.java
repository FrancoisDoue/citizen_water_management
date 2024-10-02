package com.citizen.water_management.repository;

import com.citizen.water_management.entity.Notification;
import com.citizen.water_management.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByAccount(Account account);
}
