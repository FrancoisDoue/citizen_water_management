package com.citizen.water_management.entity.location;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter @Setter
@SuperBuilder
public class GreenSpace extends Location {

    private String name;
    private String reference;

    public GreenSpace() {
        super();
    }
}
