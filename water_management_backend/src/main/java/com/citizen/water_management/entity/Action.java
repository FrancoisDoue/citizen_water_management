package com.citizen.water_management.entity;

import com.citizen.water_management.entity.account.Technician;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Action {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private LocalDateTime date;
    private String status;

    @ManyToOne
    @JoinColumn(name = "alert_id")
    @JsonIgnore
    private Alert alert;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    @JsonIgnore
    private Technician technician;
}
