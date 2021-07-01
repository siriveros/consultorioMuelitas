package com.muelitas.main.dtos;

import com.muelitas.main.entities.Dentist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DentistDTO {

    private Long dentistId;
    private String name;
    private String lastName;
    private String phone;
    private String license;

    public DentistDTO(Dentist dentist) {
        this.dentistId = dentist.getDentistId();
        this.name = dentist.getName();
        this.lastName = dentist.getLastName();
        this.phone = dentist.getPhone();
        this.license = dentist.getLicense();
    }
}
