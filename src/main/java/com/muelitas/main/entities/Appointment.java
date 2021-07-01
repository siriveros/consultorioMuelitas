package com.muelitas.main.entities;

import com.muelitas.main.dtos.AppointmentDTO;
import com.muelitas.main.enums.AppointmentStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
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

    @Enumerated(EnumType.ORDINAL)
    private AppointmentStatus status;


    public Appointment(AppointmentDTO appointmentDTO) {
        this.appointmentId = appointmentDTO.getAppointmentId();
        this.dateStart = appointmentDTO.getDateStart();
        this.patient = new Patient(appointmentDTO.getPatient());
        this.dentistSpeciality = new DentistHasSpeciality(appointmentDTO.getDentistSpeciality());
    }
    

}
