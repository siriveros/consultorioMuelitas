package com.muelitas.main.service;

import com.muelitas.main.dtos.ScheduleDTO;
import com.muelitas.main.exceptions.DataNotFoundException;

import java.util.List;


public interface ScheduleService {

    List<ScheduleDTO> findAll();

    ScheduleDTO findById(Long id) throws DataNotFoundException;

    ScheduleDTO save(ScheduleDTO scheduleDTO);

    ScheduleDTO update(ScheduleDTO scheduleDTO);

    void deleteById(Long id);

}
