package com.muelitas.main.service;

import com.muelitas.main.dtos.DentistDTO;
import com.muelitas.main.exceptions.DataNotFoundException;

import java.util.List;


public interface DentistService {

    List<DentistDTO> findAll();

    DentistDTO findById(Long id) throws DataNotFoundException;

    DentistDTO findByLicense(String license) throws DataNotFoundException;

    DentistDTO save(DentistDTO dentistDTO);

    DentistDTO update(DentistDTO dentistDTO);

    void deleteById(Long id);

}
