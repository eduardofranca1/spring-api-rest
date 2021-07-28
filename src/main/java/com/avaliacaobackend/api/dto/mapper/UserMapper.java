package com.avaliacaobackend.api.dto.mapper;

import com.avaliacaobackend.api.dto.UserResponseDTO;
import com.avaliacaobackend.domain.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserResponseDTO toResponseDTO (User user) { return new UserResponseDTO(user); }

    public static List<UserResponseDTO> toCollectionDTO (List<User> users ) {
        return users.stream()
                .map(UserMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

}
