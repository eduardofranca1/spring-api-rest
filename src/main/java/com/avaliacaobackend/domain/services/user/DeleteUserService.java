package com.avaliacaobackend.domain.services.user;

import com.avaliacaobackend.domain.exception.ResourceNotFoundException;
import com.avaliacaobackend.domain.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class DeleteUserService {

    private final UserRepository userRepository;

    @Transactional
    public void softDelete(Long userId) { userRepository.softDelete(userId); }

    public void delete(Long userId) {

        if(!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("Wrong person code, please insert the correct ID.");
        }

        userRepository.deleteById(userId);
    }
}
