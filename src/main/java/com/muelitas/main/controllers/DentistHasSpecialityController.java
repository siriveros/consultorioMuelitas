package com.muelitas.main.controllers;

import com.muelitas.main.dtos.DentistHasSpecialityDTO;
import com.muelitas.main.exceptions.DataNotFoundException;
import com.muelitas.main.service.DentistHasSpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentistHasSpeciality")
public class DentistHasSpecialityController {

    @Autowired
    private DentistHasSpecialityService dentistHasSpecialityService;

    @GetMapping
    public ResponseEntity<List<DentistHasSpecialityDTO>> findAll(){
        return ResponseEntity.ok(this.dentistHasSpecialityService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistHasSpecialityDTO> findById(@PathVariable Long id) throws DataNotFoundException {
        return ResponseEntity.ok(this.dentistHasSpecialityService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DentistHasSpecialityDTO> save(@RequestBody DentistHasSpecialityDTO dentistHasSpecialityDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.dentistHasSpecialityService.save(dentistHasSpecialityDTO));
    }

    @PutMapping
    public ResponseEntity<DentistHasSpecialityDTO> update(@RequestBody DentistHasSpecialityDTO dentistHasSpecialityDTO) throws DataNotFoundException{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.dentistHasSpecialityService.update(dentistHasSpecialityDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        this.dentistHasSpecialityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
