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
@Entity @Table(name = "water_company")
public class WaterCompany extends Account {
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "water_company_areas")
    private List<Area> areas;

}
