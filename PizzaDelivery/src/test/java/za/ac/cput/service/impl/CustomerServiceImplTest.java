package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AddressType;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Pizza;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;
/*
 * CustomerServicesImplTest.java
 * Service Test for the Customer
 * Author: Keenan Meyer - 220194920
 * Date: 09 June 2023
 * Last update: 14 June 2023
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class CustomerServiceImplTest {

    public static Address address = AddressFactory.buildAddress("21",
            "Jump Street",
            "West Olmstead",
            "Bikini Bottom",
            "California",
            "Crownlands",
            "0007",
            AddressType.RESIDENTIAL_HOME);
    public static Address address2 = AddressFactory.buildAddress(
            "5",
            "hill Street",
            "South Olmstead",
            "Bikini Bottom",
            "California",
            "Crownlands",
            "0207",
            AddressType.RESIDENTIAL_HOME);
    public static Address address3 = AddressFactory.buildAddress(
            "8",
            "Jump Street",
            "North Olmstead",
            "Bikini Bottom",
            "London",
            "Crownlands",
            "1007",
            AddressType.RESIDENTIAL_HOME);
    private static Customer customer = CustomerFactory.buildCustomer(
            "Keenan",
            "Meyer",
            "078 675 7850",
            address);

    private static Customer customer2 = CustomerFactory.buildCustomer(
            "Alison",
            "Williams",
            "078 675 7850",
            address2);

    private static Customer customer3= CustomerFactory.buildCustomer(
            "Brandon",
            "Wise",
            "078 675 7850",
            address3);
    @Autowired
    private CustomerServiceImpl service;
    //private static CustomerServiceImpl service = CustomerServiceImpl.getService();
    @Test
    void a_create() {
        Customer created = service.create(customer);
        Customer created1 = service.create(customer2);

        System.out.println(created);
        System.out.println(created1);

        assertNotNull(created);
        assertNotNull(created1);
    }

    @Test
    void b_read() {
        Customer read = service.read(customer.getCustomerID());
        Customer read2 = service.read(customer2.getCustomerID());

        System.out.println(read);
        System.out.println(read2);

        assertNotNull(customer);
        assertNotNull(customer2);
    }

    @Test
    void c_update() {
        Customer newCustomer = new Customer
                .Builder()
                .copy(customer)
                .setCustomerName("Diego")
                .setCustomerSurname("Jansen")
                .build();
        Customer updated = service.update(newCustomer);

        assertEquals(updated.getCustomerName(),newCustomer.getCustomerName());
        assertNotNull(service.update(newCustomer));
        System.out.println(newCustomer);
    }

    @Test
    void d_delete() {
        boolean deleted = service.delete(customer.getCustomerID());
        assertTrue(deleted);
        System.out.println(true + " = deleted");
    }

    @Test
    void e_getAll() {
        System.out.println(service.getAll());
    }
}
