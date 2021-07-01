package com.muelitas.main.entities;

import com.muelitas.main.dtos.DentistHasSpecialityDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class DentistHasSpeciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dentServId;

    @ManyToOne
    @JoinColumn(name="dentist_id", nullable = false)
    private Dentist dentist;

    @ManyToOne
    @JoinColumn(name="speciality_id", nullable = false)
    private Speciality speciality;

    public DentistHasSpeciality(DentistHasSpecialityDTO dentistHasSpecialityDTO) {
        this.dentServId = dentistHasSpecialityDTO.getDentServId();
        this.dentist = new Dentist(dentistHasSpecialityDTO.getDentist());
        this.speciality = new Speciality(dentistHasSpecialityDTO.getSpeciality());
    }

}
