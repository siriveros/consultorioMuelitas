package com.muelitas.main.service;

import com.muelitas.main.dtos.DentistDTO;
import com.muelitas.main.dtos.PatientListResponseDTO;
import com.muelitas.main.entities.Dentist;
import com.muelitas.main.exceptions.DataNotFoundException;
import com.muelitas.main.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DentistServiceImpl implements DentistService{

    @Autowired
    private DentistRepository dentistRepository;

    @Override
    public List<DentistDTO> findAll() {
        List<Dentist> dentistList = this.dentistRepository.findAll();
        List<DentistDTO> responseList = new ArrayList<>();
        for (Dentist dentist: dentistList){
            responseList.add(new DentistDTO(dentist));
        }
        return responseList;
    }

    @Override
    public DentistDTO findById(Long id) throws DataNotFoundException{
        Optional<Dentist> dentist = this.dentistRepository.findById(id);
        if(dentist.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro el odontologo:  " + id);
        }
        return new DentistDTO(dentist.get());
    }

    @Override
    public DentistDTO findByLicense(String license) throws DataNotFoundException {
        Optional<Dentist> dentist = this.dentistRepository.findByLicense(license);
        if(dentist.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro el odontologo:  " + license);
        }
        return new DentistDTO(dentist.get());
    }

    @Override
    public DentistDTO save(DentistDTO dentistDTO) {
        return new DentistDTO(this.dentistRepository.save(new Dentist(dentistDTO)));
    }

    @Override
    public DentistDTO update(DentistDTO dentistDTO) {
        Optional<Dentist> dentist = this.dentistRepository.findById(dentistDTO.getDentistId());
        if(dentist.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro el odontologo:  " + dentistDTO.getDentistId());
        }
        return new DentistDTO(this.dentistRepository.save(new Dentist(dentistDTO)));
    }

    @Override
    public void deleteById(Long id) {
        this.dentistRepository.deleteById(id);
    }

}
