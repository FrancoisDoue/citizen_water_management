package com.citizen.water_management.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyTechnicianRegisterDTO extends TechnicianRegisterDTO {
    private int companyId;
}
