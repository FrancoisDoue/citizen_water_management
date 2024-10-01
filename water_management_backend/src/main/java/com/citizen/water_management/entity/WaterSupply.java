package com.citizen.water_management.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Table(name = "WaterSupply")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class WaterSupply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String reference;
    private double consumptionWater;
    private double waterPressure;

    @OneToMany(mappedBy = "waterSupply")
    private List<Alert> alertList;

    //TODO lieuID
}
