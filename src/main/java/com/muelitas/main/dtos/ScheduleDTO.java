package com.muelitas.main.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.muelitas.main.entities.Schedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {


    private Long scheduleId;
    private Date start;
    private Date end;

    private String dentistLicense;

    @JsonIgnore
    private DentistDTO dentist;

    public ScheduleDTO(Schedule schedule) {
        this.scheduleId = schedule.getScheduleId();
        this.start = schedule.getStart();
        this.end = schedule.getEnd();
        this.dentistLicense = schedule.getDentist().getLicense();

        this.dentist = new DentistDTO(schedule.getDentist());
    }


}
