package com.avaliacaobackend.api.controllers;

import com.avaliacaobackend.domain.model.Address;
import com.avaliacaobackend.domain.repositories.AddressRepository;
import com.avaliacaobackend.domain.services.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Address Endpoint")
@AllArgsConstructor
@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;
    private final AddressRepository addressRepository;

    @Operation(summary = "Find all address")
    @GetMapping
    public List<Address> getAll() { return addressRepository.findAll(); }

    @Operation(summary = "Find address by id")
    @GetMapping("/{addressId}")
    public Address getById(@PathVariable Long addressId) { return addressService.getById(addressId); }

}
