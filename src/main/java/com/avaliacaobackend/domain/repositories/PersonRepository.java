package com.avaliacaobackend.domain.repositories;

import com.avaliacaobackend.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

    List<Person> findAllByAddressCity(String city);
    List<Person> findAllByAddressState(String State);
}
