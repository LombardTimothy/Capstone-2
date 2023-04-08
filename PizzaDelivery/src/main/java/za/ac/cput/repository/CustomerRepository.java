package za.ac.cput.repository;

import java.util.HashSet;
import java.util.Set;
import za.ac.cput.domain.Customer;

/*
   CustomerRepository.java
   Repository for the Customer class
   Author: Keenan Meyer (220194920)
   Date: 4th April 2023
*/
public class CustomerRepository implements ICustomerRepository{

    private static CustomerRepository repository = null;
    private Set<Customer> customerList = null;

    private CustomerRepository()
    {
        customerList = new HashSet<Customer>();
    }
    public static CustomerRepository getRepository(){
        if(repository == null)
            repository = new CustomerRepository();
        return repository;
    }
    @Override
    public Customer create(Customer customer) {
        boolean success = customerList.add(customer);
        if(!success)
            return null;
        return customer;
    }

    @Override
    public Customer read(String customerId) {
        for (Customer e: customerList
        ) {
            if(e.getCustomerID().equals(customerId))
                return e;


        } return null;
    }

    @Override
    public Customer update(Customer customer) {
        Customer buffer = read(customer.getCustomerID());
        if(buffer != null) {
            customerList.remove(buffer);
            customerList.add(customer);
            return customer;
        }
        return null;
    }

    @Override
    public boolean delete(String customerID) {
        Customer customer = read(customerID);
        if(customer == null)
            return false;
        customerList.remove(customer);
        return true;
    }
    @Override
    public Set<Customer> getAll() {
        return null;
    }

}
