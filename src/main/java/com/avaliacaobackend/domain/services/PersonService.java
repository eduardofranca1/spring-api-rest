package com.avaliacaobackend.domain.services;

import com.avaliacaobackend.domain.exception.BusinessException;
import com.avaliacaobackend.domain.exception.ResourceNotFoundException;
import com.avaliacaobackend.domain.model.Person;
import com.avaliacaobackend.domain.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final StorageService storageService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Person getById(Long personId) {
        return personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found."));
    }

    public Person create(Person person) {
//        person.setPassword(this.bCryptPasswordEncoder.encode(person.getPassword()));
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

    public Person update(Long personId, Person person) {

        Person personDB = personRepository.findById(personId).orElseThrow(() -> {
            throw new ResourceNotFoundException("Person did not found.");
        });

        BeanUtils.copyProperties(person, personDB, "id", "avatar", "address");
        BeanUtils.copyProperties(person.getAddress(), personDB.getAddress(), "id");

        if (!ObjectUtils.isEmpty(person.getAvatar())) {
            personDB.setAvatar(person.getAvatar());
        }

        return personRepository.save(personDB);
    }

    public void delete(Long personId) {

        if (!personRepository.existsById(personId)){
            throw new BusinessException("Wrong person code, please insert the correct id.");
        }

        personRepository.deleteById(personId);
    }

}
