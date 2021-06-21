package com.avaliacaobackend.domain.services;

import com.avaliacaobackend.api.dto.PasswordDTO;
import com.avaliacaobackend.domain.exception.BusinessException;
import com.avaliacaobackend.domain.exception.ResourceNotFoundException;
import com.avaliacaobackend.domain.model.User;
import com.avaliacaobackend.domain.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found."));
    }

    public User create(User user){

        boolean existingEmail = userRepository.findOptionalByEmail(user.getEmail())
                .stream()
                .anyMatch(existingUser -> !existingUser.equals(user));

        if(existingEmail){
            throw new BusinessException("Already have a user with this email.");
        }

        return userRepository.save(user);
    }

    public ResponseEntity<User> changePassword(PasswordDTO passwordDTO, Long userId) {

       var user = getById(userId);
       if (passwordEncoder.matches(passwordDTO.getPassword(), user.getPassword())) {

           user.setPassword(passwordEncoder.encode(passwordDTO.getNewPassword()));
           userRepository.save(user);
           return ResponseEntity.ok().build();

        } else {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
       }

    }

}
