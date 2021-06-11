package com.avaliacaobackend.domain.model;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_persons")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_person")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthday")
    private LocalDate birthday;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_address", unique = true)
    private Address address;

    private String selfie;

    public String getSelfieUrl() {
        return "https://myawsbucketduds.s3.sa-east-1.amazonaws.com/..." + this.selfie;
    }

    public Person() { }

    public Person(String name, String gender, LocalDate birthday, Address address, String selfie) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.selfie = selfie;
    }

    public Long getId() { return id; }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSelfie() { return selfie; }

    public void setSelfie(String selfie) { this.selfie = selfie; }

}
