package com.citizen.water_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity @Table(name = "alert")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String message;
    private boolean open;
    private LocalDateTime createdDate;

    //TODO Repository

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "water_supply_id")
    private WaterSupply waterSupply;

    @OneToMany(mappedBy = "alert")
    private List<Action> actions;
}
