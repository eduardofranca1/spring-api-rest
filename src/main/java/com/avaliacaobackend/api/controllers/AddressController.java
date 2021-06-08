package com.avaliacaobackend.api.controllers;

import com.avaliacaobackend.domain.entities.Address;
import com.avaliacaobackend.domain.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/{addressId}")
    public Address getById(@PathVariable Long addressId) {
        return addressService.read(addressId);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Address create(@RequestBody Address address) {
        return addressService.create(address);
    }

    @PutMapping("/update/{addressId}")
    public ResponseEntity<Address> update(@PathVariable Long addressId, @RequestBody Address address) {

        address.setId(addressId);
        address = addressService.update(address);

        return ResponseEntity.ok(address);
    }

    @DeleteMapping("/delete/{addressId}")
    public ResponseEntity<Void> delete(@PathVariable Long addressId) {

        addressService.delete(addressId);
        return ResponseEntity.noContent().build();

    }

}
