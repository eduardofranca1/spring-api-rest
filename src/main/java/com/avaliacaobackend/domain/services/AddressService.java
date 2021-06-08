package com.avaliacaobackend.domain.services;

import com.avaliacaobackend.domain.entities.Address;
import com.avaliacaobackend.domain.exception.BusinessException;
import com.avaliacaobackend.domain.exception.ResourceNotFoundException;
import com.avaliacaobackend.domain.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public Address read(Long addressId) {
        return addressRepository.findById(addressId)
                .orElseThrow(() -> new BusinessException("Wrong address, please try again."));
    }

    public Address create(Address address) {
        return addressRepository.save(address);
    }

    public Address update(Address address) {

        if (!addressRepository.existsById(address.getId())){
            throw new ResourceNotFoundException("Address did not found.");
        }

        return addressRepository.save(address);
    }

    public void delete(Long addressId) {

        if (!addressRepository.existsById(addressId)){
            throw new BusinessException("Wrong address, please try again.");
        }

        addressRepository.deleteById(addressId);
    }
}
