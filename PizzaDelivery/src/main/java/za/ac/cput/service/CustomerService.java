package za.ac.cput.service;

import za.ac.cput.domain.Customer;
import za.ac.cput.service.IService;

import java.util.Set;

/*
 * CustomerService.java
 * interface for the Customer Service
 * Author: Keenan Meyer - 220194920
 * Date: 09 June 2023
 */

public interface CustomerService extends IService<Customer, String> {

    boolean delete(String cusNum);

    Set<Customer> getAll();
}