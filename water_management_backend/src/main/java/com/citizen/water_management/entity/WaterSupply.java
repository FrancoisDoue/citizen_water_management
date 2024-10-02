package com.citizen.water_management.entity;


import com.citizen.water_management.entity.location.Location;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<Alert> alertList;

    @ManyToOne()
    @JoinColumn(name = "location_id")
    @JsonIgnore
    private Location location;

    @OneToMany(mappedBy = "waterSupply")
    @JsonIgnore
    private List<ConsumptionDetail> consumptionDetailList;
}
