package com.muelitas.main.dtos;

import com.muelitas.main.entities.Speciality;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecialityDTO {

    private Long specialityId;
    private String name;
    private String description;


    public SpecialityDTO(Speciality speciality) {
        this.specialityId = speciality.getSpecialityId();
        this.name = speciality.getName();
        this.description = speciality.getDescription();
    }
}
