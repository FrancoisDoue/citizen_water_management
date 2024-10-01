package com.citizen.water_management.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseRegisterDTO {
    protected String email;
    protected String password;
    protected String firstname;
    protected String lastname;
}
