package com.muelitas.main.service;

import com.muelitas.main.dtos.PatientDTO;
import com.muelitas.main.entities.Patient;
import com.muelitas.main.exceptions.DataNotFoundException;
import com.muelitas.main.repository.PatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<PatientDTO> findAll() {
        List<Patient> patientList = this.patientRepository.findAll();
        List<PatientDTO> responseList = new ArrayList<>();
        for (Patient patient: patientList){
            PatientDTO response = new PatientDTO();
            BeanUtils.copyProperties(patient,response);
            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public PatientDTO findById(Long id) throws DataNotFoundException{
        Optional<Patient> patient = this.patientRepository.findById(id);
        if(patient.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro el paciente:  " + id);
        }
        PatientDTO response = new PatientDTO();
        BeanUtils.copyProperties(patient.get(),response);
        return response;
    }

    @Override
    public PatientDTO save(PatientDTO patientDTO) {
        Patient patientEntity = new Patient();
        BeanUtils.copyProperties(patientDTO,patientEntity);
        patientEntity = this.patientRepository.save(patientEntity);
        BeanUtils.copyProperties(patientEntity,patientDTO);
        return patientDTO;
    }

    @Override
    public PatientDTO update(PatientDTO patientDTO) {
        Optional<Patient> patient = this.patientRepository.findById(patientDTO.getPatientId());
        if(patient.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro el paciente:  " + patientDTO.getPatientId());
        }
        Patient patientEntity = new Patient();
        BeanUtils.copyProperties(patientDTO,patientEntity);
        patientEntity = this.patientRepository.save(patientEntity);
        BeanUtils.copyProperties(patientEntity,patientDTO);
        return patientDTO;
    }

    @Override
    public void deleteById(Long id) {
        this.patientRepository.deleteById(id);
    }
}
