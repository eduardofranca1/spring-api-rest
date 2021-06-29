//package com.avaliacaobackend.api.dto;
//
//import com.avaliacaobackend.domain.model.Address;
//import com.avaliacaobackend.domain.model.Person;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.validation.constraints.NotEmpty;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//public class PersonDTO {
//
//    @NotEmpty
//    private String name;
//
//    @NotEmpty
//    private String gender;
//
//    private LocalDate birthday;
//    private LocalDateTime createdAt;
//    private Address address;
//
//    public Person transformToObject() { return new Person (name, gender, birthday, createdAt, address ); }
//
//}
