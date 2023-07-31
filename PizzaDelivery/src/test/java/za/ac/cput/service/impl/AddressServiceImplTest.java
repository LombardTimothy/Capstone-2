package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AddressType;
import za.ac.cput.factory.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;

/*
AddressServiceImplTest.java
Author: Tamryn Lisa Lewin (219211981)
Date: 09 June 2023
Last updated: 24 July 2023
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class AddressServiceImplTest {

    @Autowired
    private AddressServiceImpl service;

    Address address1 = AddressFactory.buildAddress("21", "Jump Street", "West Olmstead", "Bikini Bottom", "California", "Crownlands", "0007", AddressType.RESIDENTIAL_HOME);
    Address address2 = AddressFactory.buildAddress("22", "Fall Street", "12", "East Bay", "Rock Bottom", "Ohio", "Crownlands", "0006", AddressType.FLAT_BUILDING);


    @Test
    void a_create() {
        Address createdAddress1 = service.create(address1);
        Address createdAddress2 = service.create(address2);
        assertNotNull(createdAddress1);
        assertNotNull(createdAddress2);
        assertEquals(address1.getAddressId(), createdAddress1.getAddressId());
        assertEquals(address2.getAddressId(), createdAddress2.getAddressId());
        System.out.println("Created: \n" + createdAddress1 + "\n" + createdAddress2 + "\n");
    }

    @Test
    void b_read() {
        Address readAddress1 = service.read(address1.getAddressId());
        Address readAddress2 = service.read(address2.getAddressId());
        assertNotNull(readAddress1);
        assertNotNull(readAddress2);
        System.out.println("Read: \n" + readAddress1 + "\n" + readAddress2 + "\n");
    }

    @Test
    void c_update() {
//        Address newAddress = new Address.Builder().copy(address1).setStreetNumber("10").build();
//        Address updatedAddress = service.update(newAddress);
//        assertEquals(newAddress.getStreetNumber(), updatedAddress.getStreetNumber());
//        assertNotNull(service.update(newAddress));
        Address updatedAddress = new Address.Builder().copy(address1).setStreetNumber("10").build();
        service.update(updatedAddress);
        System.out.println("Updated: \n" + updatedAddress + "\n");
    }

    @Test
    void d_getAll() {
        System.out.println("All: \n" + service.getAll());
    }
}