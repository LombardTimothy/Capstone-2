package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.service.AddressService;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class AddressServiceImplTest {

    private static AddressServiceImpl service = null;

    private static Address address1 = AddressFactory.buildAddress("6", "Baker Street", "Winterfell", "0010", "North", "Westeros");
    private static Address address2 = AddressFactory.buildAddress("13A", "Elm Street", "King's Landing", "0009", "Crownlands", "Westeros");

    private AddressServiceImplTest() {
        service = AddressServiceImpl.getService();
    }

    @Test
    void a_create() {
        Address createdAddress1 = service.create(address1);
        Address createdAddress2 = service.create(address2);
        assertNotNull(createdAddress1);
        assertNotNull(createdAddress2);
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
        Address updatedAddress = new Address.Builder().copy(address1).setStreetNumber("10").setProvince("Northern Province").build();
        assertNotNull(service.update(updatedAddress));
        System.out.println("Updated: \n" + updatedAddress + "\n");
    }

    @Test
    void d_getAll() {
        System.out.println("All: \n" + service.getAll());
    }
}