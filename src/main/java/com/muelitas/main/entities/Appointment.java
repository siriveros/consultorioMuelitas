package com.muelitas.main.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    private Date dateStart;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="dent_serv_id", nullable = false)
    private DentistHasSpeciality dentistSpeciality;

}
