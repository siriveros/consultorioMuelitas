package com.muelitas.main.service;

import com.muelitas.main.dtos.PatientDTO;
import com.muelitas.main.entities.Patient;
import com.muelitas.main.exceptions.DataNotFoundException;
import com.muelitas.main.repository.PatientRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<PatientDTO> findAll() {
        List<Patient> patientList = this.patientRepository.findAll();
        List<PatientDTO> responseList = new ArrayList<>();
        for (Patient patient: patientList){
            responseList.add(new PatientDTO(patient));
        }
        return responseList;
    }

    @Override
    public PatientDTO findById(Long id) throws DataNotFoundException{
        Optional<Patient> patient = this.patientRepository.findById(id);
        if(patient.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro el paciente:  " + id);
        }
        return new PatientDTO(patient.get());
    }

    @Override
    public PatientDTO save(PatientDTO patientDTO) {
        return new PatientDTO(this.patientRepository.save(new Patient(patientDTO)));
    }

    @Override
    public PatientDTO update(PatientDTO patientDTO) {
        Optional<Patient> patient = this.patientRepository.findById(patientDTO.getPatientId());
        if(patient.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro el paciente:  " + patientDTO.getPatientId());
        }
        return new PatientDTO(this.patientRepository.save(new Patient(patientDTO)));
    }

    @Override
    public void deleteById(Long id) {
        this.patientRepository.deleteById(id);
    }

    @Override
    public List<PatientDTO> getPatientListInDay(String date) throws ParseException {
        SimpleDateFormat sp = new SimpleDateFormat("dd-MM-yyyy");
        Date startDate = sp.parse(date);
        Date endDate = DateUtils.addDays(startDate, 1);
        List<Patient> list = this.patientRepository.findPatientsByDate(startDate, endDate);
        List<PatientDTO> patients = list.stream()
                .map(app -> new PatientDTO(app)
                ).collect(Collectors.toList());

        return patients;
    }
}
