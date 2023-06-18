package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.service.CustomerService;

import java.util.List;
import java.util.Set;

/*
 * CustomerServicesImpl.java
 * Service for the Customer Implimentation
 * Author: Keenan Meyer - 220194920
 * Date: 09 June 2023
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private static CustomerServiceImpl service = null;
    private static CustomerRepository repository = null;

    private CustomerServiceImpl(){
        if(repository == null){
            repository =  CustomerRepository.getRepository();
        }
    }

    public static CustomerServiceImpl getService(){
        if(service == null){
            service = new CustomerServiceImpl();
        }
        return service;
    }


    @Override
    public Customer create(Customer customer) {
        Customer readCustomer = repository.create(customer);
        return readCustomer;
    }

    @Override
    public Customer read(String cusNum) {
        Customer read = repository.read(cusNum);
        return read;
    }

    @Override
    public Customer update(Customer cusNum) {
        Customer update = repository.update(cusNum);
        return update;
    }

    @Override
    public boolean delete(String cusNum) {
        return repository.delete(cusNum);
    }
    @Override
    public Set<Customer> getAll() {
        return repository.getAll();
    }
}




