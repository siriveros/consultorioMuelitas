package com.muelitas.main.entities;

import com.muelitas.main.dtos.PatientDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String name;

    public Patient(PatientDTO patientDTO) {
        this.patientId = patientDTO.getPatientId();
        this.name = patientDTO.getName();
    }

}
