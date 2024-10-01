package com.citizen.water_management.entity.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Entity
public class MunicipalTechnician extends Technician {
    public MunicipalTechnician() {
        super();
    }
}
