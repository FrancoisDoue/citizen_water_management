package com.citizen.water_management.entity.location;

import com.citizen.water_management.entity.account.Account;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter @Setter
@SuperBuilder
public class Home extends Location {
    public Home() {
        super();
    }

    @OneToMany(mappedBy = "home")
    private List<Account> accounts;
}
