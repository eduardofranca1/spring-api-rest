package com.avaliacaobackend.domain.services.user;

import com.avaliacaobackend.domain.exception.BusinessException;
import com.avaliacaobackend.domain.model.User;
import com.avaliacaobackend.domain.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreateUserService {

    private final UserRepository userRepository;

    public User create(User user){

        boolean existingUserName =  userRepository.findOptionalByUsername(user.getUsername())
                .stream()
                .anyMatch(existingUser -> !existingUser.equals(user));

        if (existingUserName){
            throw new BusinessException("Already have an user with this username.");
        }

        boolean existingEmail = userRepository.findOptionalByEmail(user.getEmail())
                .stream()
                .anyMatch(existingUser -> !existingUser.equals(user));

        if(existingEmail){
            throw new BusinessException("Already have an user with this email.");
        }

        return userRepository.save(user);
    }
}
