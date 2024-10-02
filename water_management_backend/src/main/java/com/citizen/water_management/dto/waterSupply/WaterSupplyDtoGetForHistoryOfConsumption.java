package com.citizen.water_management.dto.waterSupply;

import com.citizen.water_management.entity.ConsumptionDetail;
import com.citizen.water_management.entity.WaterSupply;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class WaterSupplyDtoGetForHistoryOfConsumption {

    private long id;
    private String reference;
    private double consumptionWater;
    private double waterPressure;

    private List<ConsumptionDetail> consumptionDetailList;

    public WaterSupplyDtoGetForHistoryOfConsumption(WaterSupply waterSupply) {
        this.id = waterSupply.getId();
        this.reference = waterSupply.getReference();
        this.consumptionWater = waterSupply.getConsumptionWater();
        this.waterPressure = waterSupply.getWaterPressure();
        this.consumptionDetailList = waterSupply.getConsumptionDetailList();
    }
}
