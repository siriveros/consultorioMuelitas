package com.muelitas.main.controllers;

import com.muelitas.main.dtos.ScheduleDTO;
import com.muelitas.main.exceptions.DataNotFoundException;
import com.muelitas.main.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<List<ScheduleDTO>> findAll(){
        return ResponseEntity.ok(this.scheduleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDTO> findById(@PathVariable Long id) throws DataNotFoundException {
        return ResponseEntity.ok(this.scheduleService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ScheduleDTO> save(@RequestBody ScheduleDTO scheduleDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.scheduleService.save(scheduleDTO));
    }

    @PutMapping
    public ResponseEntity<ScheduleDTO> update(@RequestBody ScheduleDTO scheduleDTO) throws DataNotFoundException{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.scheduleService.update(scheduleDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        this.scheduleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/dentist/{dentistLicense}")
    public ResponseEntity<?> getSchedulesByDentist(@PathVariable String dentistLicense){
        return ResponseEntity.ok(this.scheduleService.getSchedulesByDentist(dentistLicense));
    }

}
