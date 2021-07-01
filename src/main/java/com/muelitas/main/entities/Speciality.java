package com.muelitas.main.entities;

import com.muelitas.main.dtos.SpecialityDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specialityId;

    private String name;
    private String description;

    public Speciality(SpecialityDTO specialityDTO) {
        this.specialityId = specialityDTO.getSpecialityId();
        this.name = specialityDTO.getName();
        this.description = specialityDTO.getDescription();
    }
}
