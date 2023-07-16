package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AddressType;
import za.ac.cput.factory.AddressFactory;
import static org.junit.jupiter.api.Assertions.*;

/*
AddressRepositoryTest.java
Author: Tamryn Lisa Lewin (219211981)
Date: 06 April 2023
Last update: 14 June 2023
 */

@TestMethodOrder(MethodOrderer.MethodName.class)

class AddressRepositoryTest {
    private static AddressRepository addressRepository = AddressRepository.getRepository();
    private static Address address1 = AddressFactory.buildAddress("124", "Conch Street", "3", "Sandstone", "Sunnydale", "Sunspear", "Dorne", "0008", AddressType.FLAT_BUILDING);
    private static Address address2 = AddressFactory.buildAddress("13A", "Elm Street", "", "Duskendale", "Central City", "King's Landing", "Crownlands", "0009", AddressType.RESIDENTIAL_HOME);
    private static Address address3 = AddressFactory.buildAddress("6", "Baker Street", "", "Mystic Falls", "Gotham City", "Northern Province", "Winterfell", "0010", AddressType.RESIDENTIAL_HOME);

    @Test
    void a_address_create() {
        Address addressCreated1 = addressRepository.create(address1);
        Address addressCreated2 = addressRepository.create(address2);
        Address addressCreated3 = addressRepository.create(address3);
        assertNotNull(addressCreated1);
        assertNotNull(addressCreated2);
        assertNotNull(addressCreated3);
        System.out.println("Created: \n" + addressCreated1 + "\n" + addressCreated2 + "\n" + addressCreated3 + "\n");
    }

    @Test
    void b_address_read() {
        Address addressRead1 = addressRepository.read(address1.getAddressId());
        Address addressRead2 = addressRepository.read(address2.getAddressId());
        Address addressRead3 = addressRepository.read(address3.getAddressId());
        assertNotNull(addressRead1);
        assertNotNull(addressRead2);
        assertNotNull(addressRead3);
        System.out.println("Read: \n" + addressRead1 + "\n" + addressRead2 + "\n" + addressRead3 + "\n");
    }

    @Test
    void c_address_update() {
        Address addressUpdated1 = new Address.Builder().copy(address1)
                .setStreetNumber("111")
                .setStreetName("Evergreen Terrace")
                .setFlatNumber("1")
                .setSuburb("Dragon's Bay")
                .setCity("Yunkai")
                .setProvince("Meereen")
                .setCountry("Braavos")
                .setPostalCode("0011")
                .setAddressType(AddressType.FLAT_BUILDING)
                .build();
        assertNotNull(addressRepository.update(addressUpdated1));
        System.out.println("Updated: \n" + addressUpdated1 + "\n");
    }

    @Test
    void d_address_delete() {
        boolean addressDeleted1 = addressRepository.delete(address1.getAddressId());
        assertTrue(addressDeleted1);
        System.out.println("Deleted successfully: \n" + addressDeleted1 + "\n");
    }

    @Test
    void e_address_getAll() {
        System.out.println("All: \n" + addressRepository.getAll());
    }
}