package com.muelitas.main.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.muelitas.main.entities.Appointment;
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
    private Long specialityId;
    private String dentistLicense;

    @JsonIgnore
    private PatientDTO patient;

    @JsonIgnore
    private DentistHasSpecialityDTO dentistSpeciality;

    public AppointmentDTO(Appointment appointment) {
        this.appointmentId = appointment.getAppointmentId();
        this.dateStart = appointment.getDateStart();
        this.patientId = appointment.getPatient().getPatientId();
        this.dentistLicense = appointment.getDentistSpeciality().getDentist().getLicense();
        this.specialityId = appointment.getDentistSpeciality().getSpeciality().getSpecialityId();

        this.patient = new PatientDTO(appointment.getPatient());
        this.dentistSpeciality = new DentistHasSpecialityDTO(appointment.getDentistSpeciality());
    }
}
