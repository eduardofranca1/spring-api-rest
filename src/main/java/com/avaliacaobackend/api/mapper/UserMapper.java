package com.avaliacaobackend.api.mapper;

import com.avaliacaobackend.api.dto.UserResponseDTO;
import com.avaliacaobackend.domain.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private static ModelMapper modelMapper;

    public static UserResponseDTO toResponseDTO (User user) { return new UserResponseDTO(user); }

    public static List<UserResponseDTO> toCollectionDTO (List<User> users ) {
        return users.stream()
                .map(UserMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

//    public static UserRequestDTO toRequestDTO (User user) { return modelMapper.map(user, UserRequestDTO.class); }
//
//    public static User fromRequestDTO (UserRequestDTO user) { return modelMapper.map(user, User.class); }

}
