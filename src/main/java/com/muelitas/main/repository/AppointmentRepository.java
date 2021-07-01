package com.muelitas.main.repository;

import com.muelitas.main.entities.Appointment;
import com.muelitas.main.enums.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    List<Appointment> findByStatus(AppointmentStatus appointmentStatus);


    @Query("select a from Appointment a where a.status = :appointmentStatus and  a.dateStart between :startDate and :endDate")
    List<Appointment> findByStatusAndDate(@Param("appointmentStatus")AppointmentStatus appointmentStatus,@Param("startDate")Date startDate, @Param("endDate") Date endDate);

}
