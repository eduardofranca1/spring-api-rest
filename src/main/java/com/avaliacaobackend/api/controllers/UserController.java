package com.avaliacaobackend.api.controllers;

import com.avaliacaobackend.api.dto.PasswordDTO;
import com.avaliacaobackend.domain.model.User;
import com.avaliacaobackend.domain.repositories.UserRepository;
import com.avaliacaobackend.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public User getById(@PathVariable Long userId) {
        return userService.getById(userId);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/changePassword/{userId}")
    public ResponseEntity<User> changePassword(@RequestBody PasswordDTO passwordDTO, @PathVariable Long userId) {

        return userService.changePassword(passwordDTO, userId);

    }

}
