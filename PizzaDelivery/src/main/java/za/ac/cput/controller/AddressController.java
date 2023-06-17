package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Address;
import za.ac.cput.service.AddressService;

import java.util.Set;

/*
AddressController.java
Author: Tamryn Lisa Lewin (219211981)
Date: 13 June 2023
Last update: 13 June 2023
 */

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/create")
    public Address create(@RequestBody Address address) {
        return addressService.create(address);
    }

    @GetMapping("/read/{addressId}")
    public Address read(@PathVariable String addressId) {
        return addressService.read(addressId);
    }

    @PostMapping("/update")
    public Address update(@RequestBody Address address) {
        return addressService.update(address);
    }

    @GetMapping("/getall")
    public Set<Address> getAll() {
        return addressService.getAll();
    }
}
