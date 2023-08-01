package za.ac.cput.service;

import za.ac.cput.domain.*;

import java.util.ArrayList;

public interface CustomerAddressService extends IService<CustomerAddress, CustomerAddressId>{

    CustomerAddress create(CustomerAddress customerAddress);
    ArrayList<CustomerAddress> readCustomerIDAndAddressId(Customer customerID, Address addressId);
    ArrayList<CustomerAddress> getAll();
}
