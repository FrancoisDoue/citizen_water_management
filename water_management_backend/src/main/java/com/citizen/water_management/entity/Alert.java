package com.citizen.water_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity @Table(name = "alert")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String message;
    private boolean open;
    private LocalDateTime createdDate;

    //TODO Repository

    //TODO lieuID
    //TODO List<AlertId>
}
