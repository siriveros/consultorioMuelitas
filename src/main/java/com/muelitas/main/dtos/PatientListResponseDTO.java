package com.muelitas.main.dtos;

import lombok.Data;

import java.util.List;

@Data
public class PatientListResponseDTO {
    List<PatientDTO> patients;
}
