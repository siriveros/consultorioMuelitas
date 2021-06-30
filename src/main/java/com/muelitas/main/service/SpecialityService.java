package com.muelitas.main.service;

import com.muelitas.main.dtos.SpecialityDTO;
import com.muelitas.main.exceptions.DataNotFoundException;

import java.util.List;


public interface SpecialityService {

    List<SpecialityDTO> findAll();

    SpecialityDTO findById(Long id) throws DataNotFoundException;

    SpecialityDTO save(SpecialityDTO specialityDTO);

    SpecialityDTO update(SpecialityDTO specialityDTO);

    void deleteById(Long id);

}
