package com.citizen.water_management.entity.account;

import com.citizen.water_management.entity.Area;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Technician extends Account {
    protected String job;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    protected List<Area> areas;
}
