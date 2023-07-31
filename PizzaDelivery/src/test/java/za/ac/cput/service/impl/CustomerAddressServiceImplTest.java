package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CustomerAddressFactory;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class CustomerAddressServiceImplTest {

    @Autowired
    private CustomerAddressServiceImpl service;

    private static Address address = AddressFactory.buildAddress("22", "Fall Street", "12", "East Bay", "Rock Bottom", "Ohio", "Crownlands", "0006", AddressType.FLAT_BUILDING);
    private static Customer customer = CustomerFactory.buildCustomer("Rickon", "Stark","076 675 8090", address);
    private static CustomerAddress customerAddress = CustomerAddressFactory.buildCustomerAddress(customer, address);

    @Test
    void a_create() {
        CustomerAddress created = service.create(customerAddress);
        assertEquals(customerAddress.getCustomerID(), created.getCustomerID());
        assertEquals(customerAddress.getAddressId(), created.getAddressId());
        System.out.println("Created: \n" + created);
    }

    @Test
    void b_read() {
        final Customer customerID = customerAddress.getCustomerID();
        final Address addressId = customerAddress.getAddressId();
        System.out.println("Read: \n" + customerID + "\n" + addressId);
        System.out.println(service.readCustomerIDAndAddressId(customerID, addressId));
    }

    @Test
    void c_getAll() {
        System.out.println("All: \n" + service.getAll());
    }
}