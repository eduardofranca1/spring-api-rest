package com.avaliacaobackend.domain.services;

import com.avaliacaobackend.domain.exception.BusinessException;
import com.avaliacaobackend.domain.exception.ResourceNotFoundException;
import com.avaliacaobackend.domain.model.Address;
import com.avaliacaobackend.domain.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address getById(Long addressId) {
        return addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address does not exists."));
    }

    public void delete(Long addressId) {

        if (!addressRepository.existsById(addressId)) {
            throw new BusinessException("Wrong address code, please insert the correct id.");
        }

        addressRepository.deleteById(addressId);
    }
}
