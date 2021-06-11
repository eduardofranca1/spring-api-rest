package com.avaliacaobackend.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private Long id;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;

}
