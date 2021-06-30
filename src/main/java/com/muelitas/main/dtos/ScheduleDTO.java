package com.muelitas.main.dtos;

import lombok.Data;
import java.util.Date;

@Data
public class ScheduleDTO {


    private Long scheduleId;
    private Date start;
    private Date end;

    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="dentist_id", nullable = false)
    private DentistDTO dentist;*/
}
