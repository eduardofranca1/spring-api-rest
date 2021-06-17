package com.avaliacaobackend.domain.services;

import com.avaliacaobackend.domain.exception.BusinessException;
import com.avaliacaobackend.domain.exception.ResourceNotFoundException;
import com.avaliacaobackend.domain.model.User;
import com.avaliacaobackend.domain.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User getById(Integer userId) {
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

//        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
