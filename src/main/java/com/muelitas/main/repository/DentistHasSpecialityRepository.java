package com.muelitas.main.repository;

import com.muelitas.main.entities.DentistHasSpeciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DentistHasSpecialityRepository extends JpaRepository<DentistHasSpeciality,Long> {

    Optional<DentistHasSpeciality> findDentistHasSpecialityByDentist_LicenseAndSpeciality_SpecialityId(String license,Long specialityId);
}
