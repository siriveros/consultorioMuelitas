package com.muelitas.main.service;

import com.muelitas.main.dtos.SpecialityDTO;
import com.muelitas.main.entities.Speciality;
import com.muelitas.main.exceptions.DataNotFoundException;
import com.muelitas.main.repository.SpecialityRepository;
import org.springframework.beans.BeanUtils;
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
            SpecialityDTO response = new SpecialityDTO();
            BeanUtils.copyProperties(speciality,response);
            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public SpecialityDTO findById(Long id) throws DataNotFoundException{
        Optional<Speciality> speciality = this.specialityRepository.findById(id);
        if(speciality.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro el servicio:  " + id);
        }
        SpecialityDTO response = new SpecialityDTO();
        BeanUtils.copyProperties(speciality.get(),response);
        return response;
    }

    @Override
    public SpecialityDTO save(SpecialityDTO specialityDTO) {
        Speciality specialityEntity = new Speciality();
        BeanUtils.copyProperties(specialityDTO,specialityEntity);
        specialityEntity = this.specialityRepository.save(specialityEntity);
        BeanUtils.copyProperties(specialityEntity,specialityDTO);
        return specialityDTO;
    }

    @Override
    public SpecialityDTO update(SpecialityDTO specialityDTO) {
        Optional<Speciality> speciality = this.specialityRepository.findById(specialityDTO.getSpecialityId());
        if(speciality.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro el servicio:  " + specialityDTO.getSpecialityId());
        }
        Speciality specialityEntity = new Speciality();
        BeanUtils.copyProperties(specialityDTO,specialityEntity);
        specialityEntity = this.specialityRepository.save(specialityEntity);
        BeanUtils.copyProperties(specialityEntity,specialityDTO);
        return specialityDTO;
    }

    @Override
    public void deleteById(Long id) {
        this.specialityRepository.deleteById(id);
    }
}
