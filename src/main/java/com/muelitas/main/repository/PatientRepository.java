package com.muelitas.main.repository;


import com.muelitas.main.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query("select a.patient from Appointment a where a.dateStart between :startDate and :endDate")
    List<Patient> findPatientsByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
