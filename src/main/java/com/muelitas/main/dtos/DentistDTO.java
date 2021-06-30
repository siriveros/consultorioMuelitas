package com.muelitas.main.dtos;

import lombok.Data;

@Data
public class DentistDTO {

    private Long dentistId;
    private String name;
    private String lastName;
    private String phone;
    private String license;

}
