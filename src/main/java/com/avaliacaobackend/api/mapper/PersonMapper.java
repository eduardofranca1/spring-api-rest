package com.avaliacaobackend.api.mapper;

import com.avaliacaobackend.api.dto.PersonRequestDTO;
import com.avaliacaobackend.api.dto.PersonResponseDTO;
import com.avaliacaobackend.domain.model.Person;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PersonMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static PersonResponseDTO toResponseDTO (Person person) { return modelMapper.map(person, PersonResponseDTO.class); }

    public static List<PersonResponseDTO> toCollectionDTO(List<Person> persons) {
        return persons.stream()
                .map(PersonMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static PersonRequestDTO toRequestDTO (Person person) { return modelMapper.map(person, PersonRequestDTO.class); }

    public static Person fromRequestDTO (PersonRequestDTO person) { return modelMapper.map(person, Person.class); }
}
