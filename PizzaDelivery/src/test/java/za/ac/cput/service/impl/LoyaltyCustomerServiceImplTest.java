package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AddressType;
import za.ac.cput.domain.LoyaltyCustomer;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.LoyaltyCustomerFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class LoyaltyCustomerServiceImplTest {

    @Autowired
    private LoyaltyCustomerServiceImpl service;

    private static Address address = AddressFactory.buildAddress("10", "Long Street", "West Side", "Sandy Shores", "California", "Georgia", "9274", AddressType.RESIDENTIAL_HOME);
    private static LocalDate date = LocalDate.now();
    private static LoyaltyCustomer lc1 = LoyaltyCustomerFactory.createLoyaltyCustomer("Gabby", "Nelson", "084-837-0834", address, date, 60.0);
    private static LoyaltyCustomer lc2 = LoyaltyCustomerFactory.createLoyaltyCustomer("Wendy", "Nelson", "037-903-0924", address, date, 30.0);

    @Test
    void a_create() {
        LoyaltyCustomer createdLoyaltyCustomer1 = service.create(lc1);
        LoyaltyCustomer createdLoyaltyCustomer2 = service.create(lc2);
        assertNotNull(createdLoyaltyCustomer1);
        assertNotNull(createdLoyaltyCustomer2);
        System.out.println("Created: \n" + createdLoyaltyCustomer1 + "\n" + createdLoyaltyCustomer2 + "\n");
    }

    @Test
    void b_read() {
        LoyaltyCustomer readLoyaltyCustomer1 = service.read(String. valueOf(lc1.getCustomerID()));
        LoyaltyCustomer readLoyaltyCustomer2 = service.read(String. valueOf(lc2.getCustomerID()));
        assertNotNull(readLoyaltyCustomer1);
        assertNotNull(readLoyaltyCustomer2);
        System.out.println("Read: \n" + readLoyaltyCustomer1 + "\n" + readLoyaltyCustomer2 + "\n");
    }

    @Test
    void c_update() {
        LoyaltyCustomer updatedLoyaltyCustomer = new LoyaltyCustomer.Builder().copy(lc1).setDiscounts(50.0).build();
        assertNotNull(service.update(updatedLoyaltyCustomer));
        System.out.println("Updated: \n" + updatedLoyaltyCustomer + "\n");
    }

    @Disabled
    @Test
    void d_delete() {
        boolean deletedLoyaltyCustomer = service.delete(String. valueOf(lc2.getCustomerID()));
        assertTrue(deletedLoyaltyCustomer);
        System.out.println("Deleted successfully: \n" + deletedLoyaltyCustomer + "\n");
    }



    @Test
    void d_getAll() {
        System.out.println("All: \n" + service.getAll());
    }

}

