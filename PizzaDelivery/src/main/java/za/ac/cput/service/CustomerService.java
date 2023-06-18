package za.ac.cput.service;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Pizza;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Set;

/*
 * CustomerService.java
 * interface for the Customer Service
 * Author: Keenan Meyer - 220194920
 * Date: 09 June 2023
 */

public interface CustomerService extends IService<Customer, String> {
    //private CustomerRepository repository;
    Customer create(Customer customerID);

    Customer read(String customerID);

    Customer update(Customer customer);

    boolean delete(String customerID);
    Set<Customer> getAll();
}