package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Pizza;
import za.ac.cput.repository.AddressRepository;
import za.ac.cput.service.AddressService;

import java.util.Set;
import java.util.stream.Collectors;

/*
AddressServiceImpl.java
Author: Tamryn Lisa Lewin (219211981)
Date: 09 June 2023
Last updated: 25 September 2023
 */

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository repository;
    private AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address create(Address address) {
        return this.repository.save(address);
    }

    @Override
    public Address read(String addressId) {
        return this.repository.findById(addressId).orElse(null);
    }

    @Override
    public Address update(Address address) {
        if (this.repository.existsById(String.valueOf(address.getAddressId()))) {
            return this.repository.save(address);
        }
        return null;
    }

    @Override
    public Set<Address> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
        //return (Set<Address>) this.repository.findAll();
    }
}
