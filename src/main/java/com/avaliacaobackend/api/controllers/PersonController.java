package com.avaliacaobackend.api.controllers;

import com.avaliacaobackend.domain.model.Person;
import com.avaliacaobackend.domain.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @PostMapping(name = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody Person person) { return personService.create(person); }

    @PutMapping("/update/{personId}")
    public ResponseEntity<Person> update(@PathVariable Long personId, @RequestBody Person person) {

        person.setId(personId);
        person = personService.update(person);

        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/delete/{personId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long personId) { personService.delete(personId); }

//    @PostMapping(name = "/uploadselfie", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
//    public Person savePersonWithPhoto(@RequestPart("person") String person, @RequestPart("personSelfie") MultipartFile personSelfie) {
//        Person personJson = personService.getJson(person, file);
//        return personJson;
//    }

//    @PostMapping(name = "/uploadselfie", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
//    public Person savePersonWithPhoto(@RequestPart("person") Person person, @RequestPart("personSelfie") MultipartFile personSelfie) {
//        return personService.create(person);
//    }

//    @PostMapping("/insertfile")
//    public ResponseEntity<Person> insertFile(@RequestParam("person") String person, @RequestParam("personImage")MultipartFile personSelfie) {
//        Person obj;
//        try {
//            obj = new ObjectMapper().readValue(person, Person.class);
//            obj.setSelfie(personSelfie.getBytes());
//            obj = personService.create(obj);
//            return ResponseEntity.ok().body(obj);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}
