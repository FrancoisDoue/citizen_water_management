package com.citizen.water_management.entity.location;

import com.citizen.water_management.entity.Area;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public abstract class Location {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    protected String city;
    protected String street;
    protected int zipCode;

    @ManyToOne
    @JoinColumn(name = "area_id")
    protected Area area;
}
