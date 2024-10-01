package com.citizen.water_management.entity.account;

import com.citizen.water_management.entity.Action;
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
@Entity
public class Technician extends Account {
    private String job;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Area> areas;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "water_company_id")
    private WaterCompany waterCompany;

    @OneToMany(mappedBy = "technician")
    private List<Action> actions;
}
