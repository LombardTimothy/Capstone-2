package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.service.CustomerService;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * CustomerServicesImpl.java
 * Service for the Customer Implementation
 * Author: Keenan Meyer - 220194920
 * Date: 09 June 2023
 */


@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository repository;

    @Autowired
    private CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer create(Customer customer) {
        return this.repository.save(customer);
    }

    @Override
    public Customer read(String cusNum) {
        return this.repository.findById(cusNum).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        if (this.repository.existsById( String. valueOf(customer.getCustomerID()))) {
            return this.repository.save(customer);
        }
        return null;
    }

    @Override
    public boolean delete(String cusNum) {
        if (this.repository.existsById(cusNum)) {
            this.repository.deleteById(cusNum);
            return true;
        }
        return false;
    }

    @Override
    public Set<Customer> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
