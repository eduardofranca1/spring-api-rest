package com.avaliacaobackend.domain.services.person;

import com.avaliacaobackend.domain.exception.ResourceNotFoundException;
import com.avaliacaobackend.domain.model.Person;
import com.avaliacaobackend.domain.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FindPersonService {

    private final PersonRepository personRepository;

    public Person getById(Long personId) {
        return personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person does not found, please insert the correct ID."));
    }
}
