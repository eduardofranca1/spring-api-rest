package com.avaliacaobackend.api.dto;

import com.avaliacaobackend.domain.model.User;

public class UserResponseDTO {

    private final Long id;
    private final String userName;
    private final String email;

    public UserResponseDTO(Long id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
    }

    public static UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(user.getId(), user.getUserName(), user.getEmail());
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }


}
