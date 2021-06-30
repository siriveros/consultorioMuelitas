package com.muelitas.main.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dentistId;

    private String name;
    private String lastName;
    private String phone;

    @Column(unique = true)
    private String license;

}
