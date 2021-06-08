package com.avaliacaobackend.domain.servicies;

import com.avaliacaobackend.domain.entities.Person;
import com.avaliacaobackend.domain.exception.ResourceNotFoundException;
import com.avaliacaobackend.domain.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person read(Long personId) {
        return personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person did not found."));
    }

    public Person create(Person person) { return personRepository.save(person); }

    public Person update(Person person) {

        if (!personRepository.existsById(person.getId())) {
            throw new ResourceNotFoundException("Person did not found");
        }

        return personRepository.save(person);
    }

}
