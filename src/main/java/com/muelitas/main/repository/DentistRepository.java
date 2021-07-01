package com.muelitas.main.repository;

import com.muelitas.main.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {

    Optional<Dentist> findDentistByLicense(String license);

    @Query("select d from Dentist d where d.dentistId in (" +
            " select ds.dentist.dentistId from Appointment a " +
            "    inner join a.dentistSpeciality as ds " +
            "    where a.dateStart between :startDate and :endDate " +
            "    group by ds.dentist.dentistId having count(ds.dentist.dentistId) >= 2)")
    List<Dentist> findDentistByAppointmentCountInDay(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
