package com.muelitas.main.service;

import com.muelitas.main.dtos.DentistHasSpecialityDTO;
import com.muelitas.main.exceptions.DataNotFoundException;

import java.util.List;


public interface DentistHasSpecialityService {

    List<DentistHasSpecialityDTO> findAll();

    DentistHasSpecialityDTO findById(Long id) throws DataNotFoundException;

    DentistHasSpecialityDTO save(DentistHasSpecialityDTO dentistHasSpecialityDTO);

    DentistHasSpecialityDTO update(DentistHasSpecialityDTO dentistHasSpecialityDTO);

    void deleteById(Long id);

    DentistHasSpecialityDTO findDentistHasSpecialityByDentist_LicenseAndSpeciality_SpecialityId(String license, Long specialityId) throws DataNotFoundException;

}
