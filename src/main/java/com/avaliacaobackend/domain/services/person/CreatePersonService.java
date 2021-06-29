package com.avaliacaobackend.domain.services.person;

import com.avaliacaobackend.domain.model.Person;
import com.avaliacaobackend.domain.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreatePersonService {

    private final PersonRepository personRepository;

    public Person create(Person person) {
        return personRepository.save(person);
    }
}
