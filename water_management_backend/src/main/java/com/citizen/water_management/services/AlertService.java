package com.citizen.water_management.services;

import com.citizen.water_management.dto.alert.AlertDtoGet;
import com.citizen.water_management.dto.alert.AlertDtoPost;
import com.citizen.water_management.entity.Alert;
import com.citizen.water_management.entity.WaterSupply;
import com.citizen.water_management.repository.ActionRepository;
import com.citizen.water_management.repository.AlertRepository;
import com.citizen.water_management.repository.WaterSupplyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AlertService {

    private final AlertRepository alertRepository;
    private final ActionRepository actionRepository;
    private final WaterSupplyRepository waterSupplyRepository;

    public AlertService(AlertRepository alertRepository, ActionRepository actionRepository, WaterSupplyRepository waterSupplyRepository) {
        this.alertRepository = alertRepository;
        this.actionRepository = actionRepository;
        this.waterSupplyRepository = waterSupplyRepository;
    }

    public AlertDtoGet addAlert(AlertDtoPost alertDtoPost) {
        Optional<WaterSupply> waterSupply = waterSupplyRepository.findById(alertDtoPost.getWaterSupply());
        if (waterSupply.isEmpty()) {
            throw new IllegalArgumentException("Water supply not found");
        }

        Alert alert = Alert.builder()
                .title(alertDtoPost.getTitle())
                .message(alertDtoPost.getMessage())
                .waterSupply(waterSupply.get())
                .open(true)
                .createdDate(LocalDateTime.now())
                .build();
        alertRepository.save(alert);
        return new AlertDtoGet(alert);
    }
}
