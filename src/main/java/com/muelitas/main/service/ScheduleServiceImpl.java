package com.muelitas.main.service;

import com.muelitas.main.dtos.ScheduleDTO;
import com.muelitas.main.entities.Schedule;
import com.muelitas.main.exceptions.DataNotFoundException;
import com.muelitas.main.repository.ScheduleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<ScheduleDTO> findAll() {
        List<Schedule> scheduleList = this.scheduleRepository.findAll();
        List<ScheduleDTO> responseList = new ArrayList<>();
        for (Schedule schedule: scheduleList){
            ScheduleDTO response = new ScheduleDTO();
            BeanUtils.copyProperties(schedule,response);
            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public ScheduleDTO findById(Long id) throws DataNotFoundException{
        Optional<Schedule> schedule = this.scheduleRepository.findById(id);
        if(schedule.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro la agenda:  " + id);
        }
        ScheduleDTO response = new ScheduleDTO();
        BeanUtils.copyProperties(schedule.get(),response);
        return response;
    }

    @Override
    public ScheduleDTO save(ScheduleDTO scheduleDTO) {
        Schedule scheduleEntity = new Schedule();
        BeanUtils.copyProperties(scheduleDTO,scheduleEntity);
        scheduleEntity = this.scheduleRepository.save(scheduleEntity);
        BeanUtils.copyProperties(scheduleEntity,scheduleDTO);
        return scheduleDTO;
    }

    @Override
    public ScheduleDTO update(ScheduleDTO scheduleDTO) {
        Optional<Schedule> schedule = this.scheduleRepository.findById(scheduleDTO.getScheduleId());
        if(schedule.isEmpty()){
            throw new DataNotFoundException("Error, no se encontro la agenda:  " + scheduleDTO.getScheduleId());
        }
        Schedule scheduleEntity = new Schedule();
        BeanUtils.copyProperties(scheduleDTO,scheduleEntity);
        scheduleEntity = this.scheduleRepository.save(scheduleEntity);
        BeanUtils.copyProperties(scheduleEntity,scheduleDTO);
        return scheduleDTO;
    }

    @Override
    public void deleteById(Long id) {
        this.scheduleRepository.deleteById(id);
    }
}
