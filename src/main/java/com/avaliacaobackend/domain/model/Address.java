package com.avaliacaobackend.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_address")
public class Address {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_address")
    private Long id;

    private String address;
    private String city;
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    private String country;

    // IMPORTANTE: testar com unidirecional

    @OneToOne(mappedBy = "address")
    private Person person;
}
