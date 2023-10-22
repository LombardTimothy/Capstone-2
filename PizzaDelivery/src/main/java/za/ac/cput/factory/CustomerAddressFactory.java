package za.ac.cput.factory;

/*
CustomerAddressFactory.java
Author: Tamryn Lisa Lewin (219211981)
Date: 24 July 2023
Last update:  2023
 */

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.CustomerAddress;
import za.ac.cput.util.Helper;

public class CustomerAddressFactory {

    public static CustomerAddress buildCustomerAddress(Customer customerID, Address addressId) {
        if (Helper.isNullOrEmpty(String.valueOf(customerID)) || Helper.isNullOrEmpty(String.valueOf(addressId))) {
            return null;
        }

        CustomerAddress customerAddress = new CustomerAddress.Builder()
                .setCustomerID(customerID)
                .setAddressId(addressId)
                .build();
        return customerAddress;
    }
}
