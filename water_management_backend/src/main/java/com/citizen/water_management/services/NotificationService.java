package com.citizen.water_management.services;

import com.citizen.water_management.dto.notification.NotificationDtoGet;
import com.citizen.water_management.dto.notification.NotificationDtoPost;
import com.citizen.water_management.entity.Notification;
import com.citizen.water_management.entity.account.Account;
import com.citizen.water_management.repository.NotificationRepository;
import com.citizen.water_management.repository.account.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final AccountRepository accountRepository;

    public NotificationService(NotificationRepository notificationRepository, AccountRepository accountRepository) {
        this.notificationRepository = notificationRepository;
        this.accountRepository = accountRepository;
    }

    public NotificationDtoGet addNotification(NotificationDtoPost notificationDtoPost){
        Optional<Account> account = accountRepository.findById(notificationDtoPost.getAccountId());

        if(account.isEmpty()) throw new IllegalArgumentException("Account Not found");

        Notification notification = Notification.builder()
                .title(notificationDtoPost.getTitle())
                .imageUrl(notificationDtoPost.getImageUrl())
                .message(notificationDtoPost.getMessage())
                .open(false)
                .createdDate(LocalDateTime.now())
                .build();
        notificationRepository.save(notification);
        return new NotificationDtoGet(notification);
    }
}
