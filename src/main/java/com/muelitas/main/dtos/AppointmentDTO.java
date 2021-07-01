package com.muelitas.main.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.muelitas.main.entities.Appointment;
import com.muelitas.main.enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {

    private Long appointmentId;
    private Date dateStart;
    private Long patientId;
    private Long dentistSpecialityId;
    private AppointmentStatus status;


    @JsonIgnore
    private PatientDTO patient;

    @JsonIgnore
    private DentistHasSpecialityDTO dentistSpeciality;

    public AppointmentDTO(Appointment appointment) {
        this.appointmentId = appointment.getAppointmentId();
        this.dateStart = appointment.getDateStart();
        this.patientId = appointment.getPatient().getPatientId();
        this.dentistSpecialityId = appointment.getDentistSpeciality().getDentServId();
        this.status = appointment.getStatus();
        this.patient = new PatientDTO(appointment.getPatient());
        this.dentistSpeciality = new DentistHasSpecialityDTO(appointment.getDentistSpeciality());
    }
}
