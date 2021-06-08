package com.avaliacaobackend.api.controllers;

import com.avaliacaobackend.domain.entities.Person;
import com.avaliacaobackend.domain.servicies.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<Person> getAll() { return personService.getAll(); }

    @GetMapping("/{personId}")
    public Person getBydId(@PathVariable Long personId) { return personService.read(personId); }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Person register(@RequestBody Person person) { return personService.create(person); }

    @PutMapping("/update/{personId}")
    public ResponseEntity<Person> update(@PathVariable Long personId, @RequestBody Person person) {

        person.setId(personId);
        person = personService.update(person);

        return ResponseEntity.ok(person);
    }
}
