package com.avaliacaobackend.api.controllers;

import com.avaliacaobackend.api.dto.UserDTO;
import com.avaliacaobackend.api.dto.UserResponseDTO;
import com.avaliacaobackend.domain.model.User;
import com.avaliacaobackend.domain.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Register User Endpoint")
@AllArgsConstructor
@RestController
@RequestMapping("/user/register")
public class RegisterUserController {

    private final UserService userService;

    @Operation(summary = "Register new user")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO create(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.create(userDTO.transformToObject());
        return UserResponseDTO.toResponseDTO(user);
    }
}
