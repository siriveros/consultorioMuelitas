package com.muelitas.main.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    private Date start;
    private Date end;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="dentist_id", nullable = false)
    private Dentist dentist;
}
