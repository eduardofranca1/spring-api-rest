package com.avaliacaobackend.api.dto;

import com.avaliacaobackend.domain.model.Person;
import com.avaliacaobackend.domain.model.User;

public class UserResponseDTO {

    private final Long id;
    private final String userName;
    private final String email;
    private final Person person;

    public UserResponseDTO(Long id, String userName, String email, Person person) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.person = person;
    }

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.userName = user.getUsername();
        this.email = user.getEmail();
        this.person = user.getPerson();
    }

    public static UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(user.getId(), user.getUsername(), user.getEmail(), user.getPerson());
    }

    public Long getId() {
        return id;
    }

    public String getUserName() { return userName; }

    public String getEmail() {
        return email;
    }

    public Person getPerson() { return person; }

}
