package com.avaliacaobackend.domain.services.user;

import com.avaliacaobackend.domain.exception.ResourceNotFoundException;
import com.avaliacaobackend.domain.model.User;
import com.avaliacaobackend.domain.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FindUserService {

    private final UserRepository userRepository;

    public User getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User does not found."));
    }
}
