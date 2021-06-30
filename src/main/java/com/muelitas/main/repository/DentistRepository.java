package com.muelitas.main.repository;

import com.muelitas.main.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {
}
