package com.muelitas.main.service;

import com.muelitas.main.dtos.AppointmentDTO;
import com.muelitas.main.dtos.PatientListResponseDTO;
import com.muelitas.main.exceptions.DataNotFoundException;

import java.text.ParseException;
import java.util.List;


public interface AppointmentService {

    List<AppointmentDTO> findAll();

    AppointmentDTO findById(Long id) throws DataNotFoundException;

    AppointmentDTO save(AppointmentDTO appointmentDTO);

    AppointmentDTO update(AppointmentDTO appointmentDTO);

    void deleteById(Long id);

    PatientListResponseDTO getPatientList(String date) throws ParseException;
    void getDentistMoreThanTwo(String date) throws ParseException;

}
