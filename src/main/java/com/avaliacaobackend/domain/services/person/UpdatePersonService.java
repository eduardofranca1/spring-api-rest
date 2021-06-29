package com.avaliacaobackend.domain.services.person;

import com.avaliacaobackend.domain.exception.BusinessException;
import com.avaliacaobackend.domain.exception.ResourceNotFoundException;
import com.avaliacaobackend.domain.model.Person;
import com.avaliacaobackend.domain.repositories.PersonRepository;
import com.avaliacaobackend.domain.services.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Service
public class UpdatePersonService {

    private final PersonRepository personRepository;
    private final StorageService storageService;

    public void changeAvatar(Long personId, MultipartFile file) {

        Person person = personRepository.findById(personId).orElseThrow();

        if (file.isEmpty() ||  (!file.getContentType().equalsIgnoreCase("image/jpeg") && !file.getContentType().equalsIgnoreCase("image/png"))) {
            throw new BusinessException("Image type not match, please insert an image jpeg or png.");
        }

        if (!ObjectUtils.isEmpty(person.getAvatar())){
            storageService.deleteFile(person.getAvatar());
        }

        String randomName = this.storageService.uploadFile(file);

        person.setAvatar(randomName);
        personRepository.save(person);

    }

    public Person update(Long personId, Person person) {

        Person personDB = personRepository.findById(personId).orElseThrow(() -> {
            throw new ResourceNotFoundException("Person does not found, please insert the correct ID.");
        });

        // para ignorar os atributos passados em " " na hora de fazer o update em Person
        BeanUtils.copyProperties(person, personDB, "id", "avatar", "address", "createdAt", "updatedAt");
        BeanUtils.copyProperties(person.getAddress(), personDB.getAddress(), "id", "createdAt", "updatedAt");

        if (!ObjectUtils.isEmpty(person.getAvatar())) {
            personDB.setAvatar(person.getAvatar());
        }

        return personRepository.save(personDB);
    }
}
