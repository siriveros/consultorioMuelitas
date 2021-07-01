package com.muelitas.main.repository;

import com.muelitas.main.entities.Dentist;
import com.muelitas.main.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    List<Schedule> findByDentist(Dentist dentist);
}
