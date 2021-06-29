package com.avaliacaobackend.api.controllers;

import com.avaliacaobackend.domain.jwt.JwtUtil;
import com.avaliacaobackend.domain.model.AuthRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Auth Endpoint")
@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Operation(summary = "User authentication")
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws UsernameNotFoundException {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (UsernameNotFoundException ex) {
            throw new UsernameNotFoundException("Invalid username or password, please try again");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }

}
