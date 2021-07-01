package com.muelitas.main.dtos;

import com.muelitas.main.entities.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    private Long patientId;
    private String name;

    public PatientDTO(Patient patient) {
        this.patientId = patient.getPatientId();
        this.name = patient.getName();
    }
}
