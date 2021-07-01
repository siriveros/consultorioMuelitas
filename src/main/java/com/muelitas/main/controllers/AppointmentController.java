package com.muelitas.main.controllers;

import com.muelitas.main.dtos.AppointmentDTO;
import com.muelitas.main.exceptions.DataNotFoundException;
import com.muelitas.main.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> findAll(){
        return ResponseEntity.ok(this.appointmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> findById(@PathVariable Long id) throws DataNotFoundException {
        return ResponseEntity.ok(this.appointmentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> save(@RequestBody AppointmentDTO appointmentDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.appointmentService.save(appointmentDTO));
    }

    @PutMapping
    public ResponseEntity<AppointmentDTO> update(@RequestBody AppointmentDTO appointmentDTO) throws DataNotFoundException{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.appointmentService.update(appointmentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        this.appointmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ended")
    public ResponseEntity<?> getEndedAppointments() {
        return ResponseEntity.ok(this.appointmentService.getEndedAppointments());
    }

    @GetMapping("/pendingInDay/{date}")
    public ResponseEntity<?> getPendingAppointmentsInDay(@PathVariable String date) throws ParseException {
        return ResponseEntity.ok(this.appointmentService.getPendingAppointmentsInDay(date));
    }
}
