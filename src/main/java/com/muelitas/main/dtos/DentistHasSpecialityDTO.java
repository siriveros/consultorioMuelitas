package com.muelitas.main.dtos;

import lombok.Data;

import javax.persistence.*;

@Data
public class DentistHasSpecialityDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dentServId;

    @ManyToOne
    @JoinColumn(name="dentist_id", nullable = false)
    private DentistDTO dentist;

    @ManyToOne
    @JoinColumn(name="speciality_id", nullable = false)
    private SpecialityDTO speciality;

}
