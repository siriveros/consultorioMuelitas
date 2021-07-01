package com.muelitas.main.service;

import com.muelitas.main.dtos.ScheduleDTO;
import com.muelitas.main.entities.Schedule;
import com.muelitas.main.exceptions.DataNotFoundException;
import com.muelitas.main.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private DentistService dentistService;

    @Override
    public List<ScheduleDTO> findAll() {
        List<Schedule> scheduleList = this.scheduleRepository.findAll();
        List<ScheduleDTO> responseList = new ArrayList<>();
        for (Schedule schedule: scheduleList){
            responseList.add(new ScheduleDTO(schedule));
        }
        return responseList;
    }

    @Override
    public ScheduleDTO findById(Long id) throws DataNotFoundException{
        Optional<Schedule> schedule = this.scheduleRepository.findById(id);
        if(schedule.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro la agenda:  " + id);
        }
        return new ScheduleDTO(schedule.get());
    }

    @Override
    public ScheduleDTO save(ScheduleDTO scheduleDTO) {
        scheduleDTO.setDentist(this.dentistService.findByLicense(scheduleDTO.getDentistLicense()));
        return new ScheduleDTO(this.scheduleRepository.save(new Schedule(scheduleDTO)));
    }

    @Override
    public ScheduleDTO update(ScheduleDTO scheduleDTO) {
        Optional<Schedule> schedule = this.scheduleRepository.findById(scheduleDTO.getScheduleId());
        if(schedule.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro la agenda  " + scheduleDTO.getScheduleId());
        }
        scheduleDTO.setDentist(this.dentistService.findByLicense(scheduleDTO.getDentistLicense()));
        return new ScheduleDTO(this.scheduleRepository.save(new Schedule(scheduleDTO)));
    }

    @Override
    public void deleteById(Long id) {
        this.scheduleRepository.deleteById(id);
    }
}
