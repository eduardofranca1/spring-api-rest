package com.avaliacaobackend.domain.services.person;

import com.avaliacaobackend.domain.exception.BusinessException;
import com.avaliacaobackend.domain.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeletePersonService {

    private final PersonRepository personRepository;

    public void delete(Long personId) {

        if (!personRepository.existsById(personId)){
            throw new BusinessException("Wrong person code, please insert the correct ID.");
        }

        personRepository.deleteById(personId);
    }
}
