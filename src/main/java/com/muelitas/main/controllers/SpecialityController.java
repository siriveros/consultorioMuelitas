package com.muelitas.main.controllers;

import com.muelitas.main.dtos.SpecialityDTO;
import com.muelitas.main.exceptions.DataNotFoundException;
import com.muelitas.main.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @GetMapping
    public ResponseEntity<List<SpecialityDTO>> findAll(){
        return ResponseEntity.ok(this.specialityService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecialityDTO> findById(@PathVariable Long id) throws DataNotFoundException {
        return ResponseEntity.ok(this.specialityService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SpecialityDTO> save(@RequestBody SpecialityDTO specialityDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.specialityService.save(specialityDTO));
    }

    @PutMapping
    public ResponseEntity<SpecialityDTO> update(@RequestBody SpecialityDTO specialityDTO) throws DataNotFoundException{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.specialityService.update(specialityDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        this.specialityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
