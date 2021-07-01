package com.muelitas.main.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.muelitas.main.entities.DentistHasSpeciality;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DentistHasSpecialityDTO {

    private Long dentServId;
    private String dentistLicense;
    private Long specialityId;

    @JsonIgnore
    private DentistDTO dentist;

    @JsonIgnore
    private SpecialityDTO speciality;

    public DentistHasSpecialityDTO(DentistHasSpeciality dentistHasSpeciality) {
        this.dentServId = dentistHasSpeciality.getDentServId();
        this.dentistLicense = dentistHasSpeciality.getDentist().getLicense();
        this.specialityId = dentistHasSpeciality.getSpeciality().getSpecialityId();

        this.dentist = new DentistDTO(dentistHasSpeciality.getDentist());
        this.speciality = new SpecialityDTO(dentistHasSpeciality.getSpeciality());
    }
}
