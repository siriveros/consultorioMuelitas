package com.muelitas.main.service;

import com.muelitas.main.dtos.SpecialityDTO;
import com.muelitas.main.entities.Speciality;
import com.muelitas.main.exceptions.DataNotFoundException;
import com.muelitas.main.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpecialityServiceImpl implements SpecialityService{

    @Autowired
    private SpecialityRepository specialityRepository;

    @Override
    public List<SpecialityDTO> findAll() {
        List<Speciality> specialityList = this.specialityRepository.findAll();
        List<SpecialityDTO> responseList = new ArrayList<>();
        for (Speciality speciality: specialityList){
            responseList.add(new SpecialityDTO(speciality));
        }
        return responseList;
    }

    @Override
    public SpecialityDTO findById(Long id) throws DataNotFoundException{
        Optional<Speciality> speciality = this.specialityRepository.findById(id);
        if(speciality.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro el odontologo:  " + id);
        }
        return new SpecialityDTO(speciality.get());
    }

    @Override
    public SpecialityDTO save(SpecialityDTO specialityDTO) {
        return new SpecialityDTO(this.specialityRepository.save(new Speciality(specialityDTO)));
    }

    @Override
    public SpecialityDTO update(SpecialityDTO specialityDTO) {
        Optional<Speciality> speciality = this.specialityRepository.findById(specialityDTO.getSpecialityId());
        if(speciality.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro el odontologo:  " + specialityDTO.getSpecialityId());
        }
        return new SpecialityDTO(this.specialityRepository.save(new Speciality(specialityDTO)));
    }

    @Override
    public void deleteById(Long id) {
        this.specialityRepository.deleteById(id);
    }
}
