//package com.avaliacaobackend.api.dto;
//
//import com.avaliacaobackend.domain.model.Address;
//import com.avaliacaobackend.domain.model.Person;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import org.springframework.util.ObjectUtils;
//
//import java.time.LocalDate;
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//public class PersonResponseDTO {
//
//    private final Long id;
//    private final String name;
//    private final String gender;
//    private final LocalDate birthday;
//    private final Address address;
//    private final String avatar;
//
//    public PersonResponseDTO(Long id, String name, String gender, LocalDate birthday, Address address, String avatar) {
//        this.id = id;
//        this.name = name;
//        this.gender = gender;
//        this.birthday = birthday;
//        this.address = address;
//        this.avatar = avatar;
//    }
//
//    public PersonResponseDTO(Person person) {
//        this.id = person.getId();
//        this.name = person.getName();
//        this.gender = person.getGender();
//        this.birthday = person.getBirthday();
//        this.address = person.getAddress();
//        this.avatar = person.getAvatar();
//    }
//
//    public static PersonResponseDTO toResponseDTO(Person person) {
//        return new PersonResponseDTO(person.getId(), person.getName(), person.getGender(),
//                person.getBirthday(), person.getAddress(), person.getAvatar());
//    }
//
//    public String getAvatarUrl() {
//
//        if (ObjectUtils.isEmpty(this.avatar)) {
//            return null;
//        }
//        return "https://myawsbucketduds.s3.sa-east-1.amazonaws.com/" + this.avatar;
//    }
//
//    public Long getId() { return id; }
//
//    public String getName() { return name; }
//
//    public String getGender() { return gender; }
//
//    public LocalDate getBirthday() { return birthday; }
//
//    public Address getAddress() { return address; }
//
//    public String getAvatar() { return avatar; }
//
//}
