package com.avaliacaobackend.domain.services.user;

import com.avaliacaobackend.api.dto.PasswordDTO;
import com.avaliacaobackend.domain.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ChangePasswordUserService {

    private final FindUserService findUserService;
    private final UserRepository userRepository;
    private final static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean changePassword(PasswordDTO passwordDTO, Long userId) {

        var user = findUserService.getById(userId);

        if (passwordEncoder.matches(passwordDTO.getPassword(), user.getPassword())) {

            user.setPassword(passwordEncoder.encode(passwordDTO.getNewPassword()));
            userRepository.save(user);

            return true;
        }

        return false;

    }
}
