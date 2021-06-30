package com.muelitas.main.service;

import com.muelitas.main.dtos.AppointmentDTO;
import com.muelitas.main.entities.Appointment;
import com.muelitas.main.exceptions.DataNotFoundException;
import com.muelitas.main.repository.AppointmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<AppointmentDTO> findAll() {
        List<Appointment> appointmentList = this.appointmentRepository.findAll();
        List<AppointmentDTO> responseList = new ArrayList<>();
        for (Appointment appointment: appointmentList){
            AppointmentDTO response = new AppointmentDTO();
            BeanUtils.copyProperties(appointment,response);
            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public AppointmentDTO findById(Long id) throws DataNotFoundException{
        Optional<Appointment> appointment = this.appointmentRepository.findById(id);
        if(appointment.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro el turno:  " + id);
        }
        AppointmentDTO response = new AppointmentDTO();
        BeanUtils.copyProperties(appointment.get(),response);
        return response;
    }

    @Override
    public AppointmentDTO save(AppointmentDTO appointmentDTO) {
        Appointment appointmentEntity = new Appointment();
        BeanUtils.copyProperties(appointmentDTO,appointmentEntity);
        appointmentEntity = this.appointmentRepository.save(appointmentEntity);
        BeanUtils.copyProperties(appointmentEntity,appointmentDTO);
        return appointmentDTO;
    }

    @Override
    public AppointmentDTO update(AppointmentDTO appointmentDTO) {
        Optional<Appointment> appointment = this.appointmentRepository.findById(appointmentDTO.getAppointmentId());
        if(appointment.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro el turno:  " + appointmentDTO.getAppointmentId());
        }
        Appointment appointmentEntity = new Appointment();
        BeanUtils.copyProperties(appointmentDTO,appointmentEntity);
        appointmentEntity = this.appointmentRepository.save(appointmentEntity);
        BeanUtils.copyProperties(appointmentEntity,appointmentDTO);
        return appointmentDTO;
    }

    @Override
    public void deleteById(Long id) {
        this.appointmentRepository.deleteById(id);
    }
}
