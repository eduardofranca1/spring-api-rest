package com.avaliacaobackend.api.controllers;

import com.avaliacaobackend.domain.model.Address;
import com.avaliacaobackend.domain.repositories.AddressRepository;
import com.avaliacaobackend.domain.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;
    private final AddressRepository addressRepository;

    @GetMapping
    public List<Address> getAll() { return addressRepository.findAll(); }

    @GetMapping("/{addressId}")
    public Address getById(@PathVariable Long addressId) { return addressService.getById(addressId); }

    @DeleteMapping("/{addressId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long addressId) { addressService.delete(addressId); }

}
