package com.muelitas.main.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String name;

}
