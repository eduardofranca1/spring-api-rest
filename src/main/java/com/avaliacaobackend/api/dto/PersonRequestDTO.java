package com.avaliacaobackend.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PersonRequestDTO {

    private String name;
    private String gender;
    private String email;
    private String password;
    private LocalDate birthday;
    private AddressDTO address;

}
