package com.citizen.water_management.dto.alert;

import com.citizen.water_management.entity.Action;
import com.citizen.water_management.entity.Alert;
import com.citizen.water_management.entity.WaterSupply;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class AlertDtoGet {

    private long id;

    private String title;
    private String message;
    private boolean open;
    private LocalDateTime createdDate;

    private WaterSupply waterSupply;
    private List<Action> actions;

    public AlertDtoGet(Alert alert) {
        this.id = alert.getId();
        this.title = alert.getTitle();
        this.message = alert.getMessage();
        this.open = alert.isOpen();
        this.createdDate = alert.getCreatedDate();
        this.waterSupply = alert.getWaterSupply();
        this.actions = alert.getActions();
    }
}
