package com.avaliacaobackend.api.dto;

import com.avaliacaobackend.domain.model.Person;
import com.avaliacaobackend.domain.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserDTO {

    @NotEmpty
    private String userName;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;

    private Person person;

    public User transformToObject() {
        return new User(userName, email, password, person);
    }

}
