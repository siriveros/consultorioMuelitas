package com.muelitas.main.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specialityId;

    private String name;
    private String description;
}
