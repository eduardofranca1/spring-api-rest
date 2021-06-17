package com.avaliacaobackend.api.controllers;

import com.avaliacaobackend.domain.model.User;
import com.avaliacaobackend.domain.repositories.UserRepository;
import com.avaliacaobackend.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private AuthenticationManager authenticationManager;

//    @GetMapping("/search")
//    public ResponseEntity<User> findByEmail(@RequestParam String email) {
//        User user = userService.findOptionalByEmail(email);
//        return ResponseEntity.ok(user);
//    }

    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public User getById(@PathVariable Integer userId) {
        return userService.getById(userId);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

//    @PostMapping("/login")
//    public String login(@RequestBody UserDTO userDTO) {
//         return userDTO.buildToken(authenticationManager);
//    }

}
