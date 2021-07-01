package com.muelitas.main.service;

import com.muelitas.main.dtos.PatientDTO;
import com.muelitas.main.exceptions.DataNotFoundException;

import java.text.ParseException;
import java.util.List;


public interface PatientService {

    List<PatientDTO> findAll();

    PatientDTO findById(Long id) throws DataNotFoundException;

    PatientDTO save(PatientDTO patientDTO);

    PatientDTO update(PatientDTO patientDTO);

    void deleteById(Long id);

    List<PatientDTO> getPatientListInDay(String date) throws ParseException;

}
