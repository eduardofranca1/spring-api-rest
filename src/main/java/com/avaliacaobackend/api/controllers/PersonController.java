package com.avaliacaobackend.api.controllers;

import com.avaliacaobackend.api.dto.PersonRequestDTO;
import com.avaliacaobackend.api.dto.PersonResponseDTO;
import com.avaliacaobackend.api.mapper.PersonMapper;
import com.avaliacaobackend.domain.model.Person;
import com.avaliacaobackend.domain.repositories.PersonRepository;
import com.avaliacaobackend.domain.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonService personService;

    @GetMapping
    public List<PersonResponseDTO> getAll() {
        return personRepository.findAll()
                .stream()
                .map(PersonMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{personId}")
    public PersonResponseDTO getBydId(@PathVariable Long personId) {
       return PersonMapper.toResponseDTO(personService.getById(personId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonResponseDTO create(@RequestBody PersonRequestDTO personRequestDTO ) {

        Person person = PersonMapper.fromRequestDTO(personRequestDTO);
        personService.create(person);
        return PersonMapper.toResponseDTO(person);

    }

    @PutMapping("/{personId}")
    public ResponseEntity<Person> update(@PathVariable Long personId, @RequestBody Person person) {

        return ResponseEntity.ok(personService.update(personId, person));
    }

    @PostMapping(value = "/{personId}/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void create(@PathVariable Long personId, @RequestParam("file") MultipartFile file) {
        personService.changeAvatar(personId, file);
    }

    @DeleteMapping("/{personId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long personId) { personService.delete(personId); }

}
