package com.muelitas.main.entities;

import com.muelitas.main.dtos.ScheduleDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    private Date start;
    private Date end;

    @ManyToOne
    @JoinColumn(name="dentist_id", nullable = false)
    private Dentist dentist;

    public Schedule(ScheduleDTO scheduleDTO) {
        this.scheduleId = scheduleDTO.getScheduleId();
        this.start = scheduleDTO.getStart();
        this.end = scheduleDTO.getEnd();
        this.dentist = new Dentist(scheduleDTO.getDentist());
    }
}
