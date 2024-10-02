package com.citizen.water_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "consumption_detail")
public class ConsumptionDetail {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate startDate;
    private LocalDate endDate;
    @Column(name = "water_consumption")
    private double waterConsumption;
    @Column(name = "medium_pressure")
    private double mediumPressure;

    @ManyToOne
    @JoinColumn(name = "water_supply_id")
    @JsonIgnore
    private WaterSupply waterSupply;
}
