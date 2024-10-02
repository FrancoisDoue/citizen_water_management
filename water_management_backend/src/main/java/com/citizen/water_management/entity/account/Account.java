package com.citizen.water_management.entity.account;

import com.citizen.water_management.entity.Notification;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@SuperBuilder
@Entity @Table(name = "account")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(nullable = false, unique = true)
    protected String email;
    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected String password;
    protected String firstname;
    protected String lastname;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "role")
    protected Role role;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    protected List<Notification> notifications;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(role);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

}
