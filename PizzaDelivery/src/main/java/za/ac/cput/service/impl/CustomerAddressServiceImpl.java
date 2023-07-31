package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.CustomerAddress;
import za.ac.cput.domain.CustomerAddressId;
import za.ac.cput.repository.CustomerAddressRepository;
import za.ac.cput.service.CustomerAddressService;

import java.util.ArrayList;

@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {

    private CustomerAddressRepository repository;

    @Autowired
    public CustomerAddressServiceImpl(CustomerAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerAddress create(CustomerAddress customerAddress) {
        return this.repository.save(customerAddress);
    }

    @Override
    public CustomerAddress read(CustomerAddressId customerAddressId) {
        return null;
    }

    @Override
    public ArrayList<CustomerAddress> readCustomerIDAndAddressId(Customer customerID, Address addressId) {
        return repository.findAllByCustomerIDAndAddressId(customerID, addressId);
    }

    @Override
    public ArrayList<CustomerAddress> getAll() {
        return (ArrayList<CustomerAddress>) this.repository.findAll();
    }
}
