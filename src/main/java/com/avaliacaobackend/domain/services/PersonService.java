package com.avaliacaobackend.domain.services;

import com.avaliacaobackend.domain.exception.BusinessException;
import com.avaliacaobackend.domain.exception.ResourceNotFoundException;
import com.avaliacaobackend.domain.model.Person;
import com.avaliacaobackend.domain.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final StorageService storageService;

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person read(Long personId) {
        return personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person did not found."));
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public void changeAvatar(Long personId, MultipartFile file) {
        // busca person pelo id
        Person person = personRepository.findById(personId).orElseThrow();

        // lógica para verificar se o arquivo é válido
        if (file.isEmpty() ||  (!file.getContentType().equalsIgnoreCase("image/jpeg") && !file.getContentType().equalsIgnoreCase("image/png"))) {
            throw new BusinessException("Image type not match.");
        }

        // se person avatar estiver empty
        if (!ObjectUtils.isEmpty(person.getAvatar())){
            storageService.deleteFile(person.getAvatar());
        }
        // envia arquvio para o s3 com nome randomico
        String randomName = this.storageService.uploadFile(file);

        person.setAvatar(randomName);
        personRepository.save(person);

    }

    public Person update(Person person) {

        if (!personRepository.existsById(person.getId())) {
            throw new ResourceNotFoundException("Wrong person code, please try again.");
        }

        return personRepository.save(person);
    }

    public void delete(Long personId) {

        if (!personRepository.existsById(personId)){
            throw new BusinessException("Wrong person code, please try again.");
        }

        personRepository.deleteById(personId);
    }

//        public Person getJson(String person, MultipartFile file) {
//        Person personJson = new Person();
//
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            personJson = objectMapper.readValue(person, Person.class);
//        } catch (IOException e) {
//            throw new FileStorageException("Error");
//        }
//
//        int fileCount = file.size();
//        personJson.setCount(fileCount);
//
//        return personJson;
//    }
}
