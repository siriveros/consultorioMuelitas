package com.muelitas.main.dtos;

import lombok.Data;
import java.util.Date;

@Data
public class AppointmentDTO {

    private Long appointmentId;

    private Date dateStart;

    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="patient_id", nullable = false)
    private PatientDTO patient;

    @ManyToOne
    @JoinColumn(name="dent_serv_id", nullable = false)
    private DentistHasSpecialityDTO dentistSpeciality;*/

}
