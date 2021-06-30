package com.muelitas.main.controllers;

import com.muelitas.main.dtos.DentistDTO;
import com.muelitas.main.exceptions.DataNotFoundException;
import com.muelitas.main.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    @Autowired
    private DentistService dentistService;

    @GetMapping
    public ResponseEntity<List<DentistDTO>> findAll(){
        return ResponseEntity.ok(this.dentistService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistDTO> findById(@PathVariable Long id) throws DataNotFoundException {
        return ResponseEntity.ok(this.dentistService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DentistDTO> save(@RequestBody DentistDTO dentistDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.dentistService.save(dentistDTO));
    }

    @PutMapping
    public ResponseEntity<DentistDTO> update(@RequestBody DentistDTO dentistDTO) throws DataNotFoundException{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.dentistService.update(dentistDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        this.dentistService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
