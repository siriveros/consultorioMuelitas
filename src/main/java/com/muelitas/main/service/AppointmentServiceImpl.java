package com.muelitas.main.service;

import com.muelitas.main.dtos.AppointmentDTO;
import com.muelitas.main.dtos.PatientDTO;
import com.muelitas.main.dtos.PatientListResponseDTO;
import com.muelitas.main.entities.Appointment;
import com.muelitas.main.entities.Patient;
import com.muelitas.main.exceptions.DataNotFoundException;
import com.muelitas.main.repository.AppointmentRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;
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
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<AppointmentDTO> findAll() {
        List<Appointment> appointmentList = this.appointmentRepository.findAll();
        List<AppointmentDTO> responseList = new ArrayList<>();
        for (Appointment appointment: appointmentList){
            responseList.add(new AppointmentDTO(appointment));
        }
        return responseList;
    }

    @Override
    public AppointmentDTO findById(Long id) throws DataNotFoundException{
        Optional<Appointment> appointment = this.appointmentRepository.findById(id);
        if(appointment.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro el turno:  " + id);
        }
        return new AppointmentDTO(appointment.get());
    }

    @Override
    public AppointmentDTO save(AppointmentDTO appointmentDTO) {
        return new AppointmentDTO(this.appointmentRepository.save(new Appointment(appointmentDTO)));
    }

    @Override
    public AppointmentDTO update(AppointmentDTO appointmentDTO) {
        Optional<Appointment> appointment = this.appointmentRepository.findById(appointmentDTO.getAppointmentId());
        if(appointment.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro el turno:  " + appointmentDTO.getAppointmentId());
        }
        return new AppointmentDTO(this.appointmentRepository.save(new Appointment(appointmentDTO)));
    }

    @Override
    public void deleteById(Long id) {
        this.appointmentRepository.deleteById(id);
    }

    @Override
    public PatientListResponseDTO getPatientList(String date) throws ParseException {
        SimpleDateFormat sp = new SimpleDateFormat("dd-MM-yyyy");
        Date startDate = sp.parse(date);
        Date endDate = DateUtils.addDays(startDate, 1);
        List<Appointment> list = this.appointmentRepository.findByDate(startDate, endDate);
        List<PatientDTO> patients = list.stream()
                .map(app -> new PatientDTO(app.getPatient())
        ).collect(Collectors.toList());


        PatientListResponseDTO response = new PatientListResponseDTO();
        response.setPatients(patients);
        return response;
    }

    @Override
    public void getDentistMoreThanTwo(String date) throws ParseException {
        SimpleDateFormat sp = new SimpleDateFormat("dd-MM-yyyy");
        Date startDate = sp.parse(date);
        Date endDate = DateUtils.addDays(startDate, 1);
        List<Appointment> list = this.appointmentRepository.findByDateFiterAppointments(startDate, endDate);
    }
}
