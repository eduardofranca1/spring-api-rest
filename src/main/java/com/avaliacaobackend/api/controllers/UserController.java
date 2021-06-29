package com.avaliacaobackend.api.controllers;

import com.avaliacaobackend.api.dto.PasswordDTO;
import com.avaliacaobackend.api.dto.UserResponseDTO;
import com.avaliacaobackend.api.mapper.UserMapper;
import com.avaliacaobackend.domain.repositories.UserRepository;
import com.avaliacaobackend.domain.services.user.ChangePasswordUserService;
import com.avaliacaobackend.domain.services.user.FindUserService;
import com.avaliacaobackend.domain.services.user.DeleteUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User endpoint")
@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final FindUserService findUserService;
    private final ChangePasswordUserService changePasswordService;
    private final DeleteUserService deleteUserService;
    private final UserRepository userRepository;

    @Operation(summary = "Find user by id")
    @GetMapping("/{userId}")
    public UserResponseDTO getById(@PathVariable Long userId) {
        return UserMapper.toResponseDTO(findUserService.getById(userId));
    }

    @Operation(summary = "Find all users")
    @GetMapping
    public List<UserResponseDTO> getAll() {
        return UserMapper.toCollectionDTO(this.userRepository.findAll());
    }

    @Operation(summary = "Find enable users")
    @GetMapping("/enable")
    public List<UserResponseDTO> getAllEnable() {
        return UserMapper.toCollectionDTO(this.userRepository.findAllByDeleted(false));
    }

    @Operation(summary = "Find disabled users")
    @GetMapping("/disabled")
    public List<UserResponseDTO> getAllDisabled() { return UserMapper.toCollectionDTO(this.userRepository.findAllByDeleted(true)); }

    @Operation(summary = "Change user password by your id")
    @PutMapping("/changePassword/{userId}")
    public ResponseEntity<Boolean> changePassword(@RequestBody PasswordDTO passwordDTO, @PathVariable Long userId) {

        return changePasswordService.changePassword(passwordDTO, userId) ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();

    }

    @Operation(summary = "Soft delete user by id")
    @DeleteMapping("/disable/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long userId) {
        deleteUserService.softDelete(userId);
    }

    @Operation(summary = "Delete user by id")
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId) { deleteUserService.delete(userId); }
}
