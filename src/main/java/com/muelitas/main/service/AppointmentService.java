package com.muelitas.main.service;

import com.muelitas.main.dtos.AppointmentDTO;
import com.muelitas.main.exceptions.DataNotFoundException;

import java.util.List;


public interface AppointmentService {

    List<AppointmentDTO> findAll();

    AppointmentDTO findById(Long id) throws DataNotFoundException;

    AppointmentDTO save(AppointmentDTO appointmentDTO);

    AppointmentDTO update(AppointmentDTO appointmentDTO);

    void deleteById(Long id);

}
