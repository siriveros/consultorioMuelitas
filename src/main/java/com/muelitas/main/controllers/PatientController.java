package com.muelitas.main.controllers;

import com.muelitas.main.dtos.PatientDTO;
import com.muelitas.main.exceptions.DataNotFoundException;
import com.muelitas.main.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientDTO>> findAll(){
        return ResponseEntity.ok(this.patientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findById(@PathVariable Long id) throws DataNotFoundException {
        return ResponseEntity.ok(this.patientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PatientDTO> save(@RequestBody PatientDTO patientDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.patientService.save(patientDTO));
    }

    @PutMapping
    public ResponseEntity<PatientDTO> update(@RequestBody PatientDTO patientDTO) throws DataNotFoundException{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.patientService.update(patientDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        this.patientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
