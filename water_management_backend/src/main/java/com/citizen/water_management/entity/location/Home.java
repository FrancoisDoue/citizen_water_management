package com.citizen.water_management.entity.location;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter @Setter
@SuperBuilder
public class Home extends Location {
    public Home() {
        super();
    }

    //TODO List Citizen

}
