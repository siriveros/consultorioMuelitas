package com.muelitas.main.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DentistHasSpeciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dentServId;

    @ManyToOne
    @JoinColumn(name="dentist_id", nullable = false)
    private Dentist dentist;

    @ManyToOne
    @JoinColumn(name="speciality_id", nullable = false)
    private Speciality speciality;

}
