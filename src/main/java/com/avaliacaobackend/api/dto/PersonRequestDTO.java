package com.avaliacaobackend.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class PersonRequestDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String gender;
    private LocalDate birthday;
    private AddressDTO address;

}
