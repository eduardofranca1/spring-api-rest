package com.avaliacaobackend.domain.services;

import com.avaliacaobackend.api.dto.PasswordDTO;
import com.avaliacaobackend.domain.exception.BusinessException;
import com.avaliacaobackend.domain.exception.ResourceNotFoundException;
import com.avaliacaobackend.domain.model.User;
import com.avaliacaobackend.domain.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User does not found."));
    }

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

    public boolean changePassword(PasswordDTO passwordDTO, Long userId) {

        var user = getById(userId);

        if (passwordEncoder.matches(passwordDTO.getPassword(), user.getPassword())) {

            user.setPassword(passwordEncoder.encode(passwordDTO.getNewPassword()));
            userRepository.save(user);

            return true;
        }

        return false;

    }

    @Transactional
    public void softDelete(Long userId) { userRepository.softDelete(userId); }

}
