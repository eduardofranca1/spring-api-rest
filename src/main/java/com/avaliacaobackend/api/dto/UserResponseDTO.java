package com.avaliacaobackend.api.dto;

import com.avaliacaobackend.domain.model.Person;
import com.avaliacaobackend.domain.model.User;

public class UserResponseDTO {

    private final String id;
    private final String username;
    private final String email;
    private final Person person;

    public UserResponseDTO(String id, String username, String email, Person person) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.person = person;
    }

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.person = user.getPerson();
    }

    public static UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(user.getId(), user.getUsername(), user.getEmail(), user.getPerson());
    }

    public String getId() { return id; }

    public String getUsername() { return username; }

    public String getEmail() { return email; }

    public Person getPerson() { return person; }

}
