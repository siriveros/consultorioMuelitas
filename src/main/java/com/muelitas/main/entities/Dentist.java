package com.muelitas.main.entities;

import com.muelitas.main.dtos.DentistDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dentistId;

    private String name;
    private String lastName;
    private String phone;

    @Column(unique = true)
    private String license;

    public Dentist(DentistDTO dentistDTO) {
        this.dentistId = dentistDTO.getDentistId();
        this.name = dentistDTO.getName();
        this.lastName = dentistDTO.getLastName();
        this.phone = dentistDTO.getPhone();
        this.license = dentistDTO.getLicense();
    }
}
