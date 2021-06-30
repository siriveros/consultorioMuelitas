package com.muelitas.main.repository;

import com.muelitas.main.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    @Query("select a from Appointment a where a.dateStart between :startDate and :endDate")
    List<Appointment> findByDate(@Param("startDate")Date startDate, @Param("endDate") Date endDate);

    /*
    * select d.* from dentist d where dentist_id in (
	    select ds.dentist_id from appointment a
        inner join dentist_has_speciality ds on (a.dent_serv_id = ds.dent_serv_id)
        where a.date_start between '2021-06-29' and '2021-06-30'
        group by ds.dentist_id having count(1) > 3
);
    * */
    @Query("select d from Dentist d where d.dentistId in () ")
    List<Appointment> findByDateFiterAppointments(@Param("startDate")Date startDate, @Param("endDate") Date endDate);
}
