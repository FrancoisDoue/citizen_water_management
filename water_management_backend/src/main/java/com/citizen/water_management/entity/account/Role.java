package com.citizen.water_management.entity.account;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity @Table(name = "role")
public class Role implements GrantedAuthority {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }

}
