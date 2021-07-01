package com.muelitas.main.service;

import com.muelitas.main.dtos.DentistHasSpecialityDTO;
import com.muelitas.main.entities.DentistHasSpeciality;
import com.muelitas.main.exceptions.DataNotFoundException;
import com.muelitas.main.repository.DentistHasSpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DentistHasSpecialityServiceImpl implements DentistHasSpecialityService{

    @Autowired
    private DentistHasSpecialityRepository dentistHasSpecialityRepository;

    @Override
    public List<DentistHasSpecialityDTO> findAll() {
        List<DentistHasSpeciality> dentistHasSpecialityList = this.dentistHasSpecialityRepository.findAll();
        List<DentistHasSpecialityDTO> responseList = new ArrayList<>();
        for (DentistHasSpeciality dentistHasSpeciality: dentistHasSpecialityList){
            responseList.add(new DentistHasSpecialityDTO(dentistHasSpeciality));
        }
        return responseList;
    }

    @Override
    public DentistHasSpecialityDTO findById(Long id) throws DataNotFoundException{
        Optional<DentistHasSpeciality> dentistHasSpeciality = this.dentistHasSpecialityRepository.findById(id);
        if(dentistHasSpeciality.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro el odontologo:  " + id);
        }
        return new DentistHasSpecialityDTO(dentistHasSpeciality.get());
    }


    @Override
    public DentistHasSpecialityDTO save(DentistHasSpecialityDTO dentistHasSpecialityDTO) {
        return new DentistHasSpecialityDTO(this.dentistHasSpecialityRepository.save(new DentistHasSpeciality(dentistHasSpecialityDTO)));
    }

    @Override
    public DentistHasSpecialityDTO update(DentistHasSpecialityDTO dentistHasSpecialityDTO) {
        Optional<DentistHasSpeciality> dentistHasSpeciality = this.dentistHasSpecialityRepository.findById(dentistHasSpecialityDTO.getDentServId());
        if(dentistHasSpeciality.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro el odontologo:  " + dentistHasSpecialityDTO.getDentServId());
        }
        return new DentistHasSpecialityDTO(this.dentistHasSpecialityRepository.save(new DentistHasSpeciality(dentistHasSpecialityDTO)));
    }

    @Override
    public void deleteById(Long id) {
        this.dentistHasSpecialityRepository.deleteById(id);
    }
}
