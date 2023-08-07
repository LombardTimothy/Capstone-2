package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.LoyaltyCustomer;
import za.ac.cput.factory.LoyaltyCustomerFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class LoyaltyCustomerServiceImplTest {

    @Autowired
    private LoyaltyCustomerServiceImpl service = null;

    static LocalDate date = LocalDate.now();
    private static LoyaltyCustomer lc1 = LoyaltyCustomerFactory.createLoyaltyCustomer(date,35.34);
    private static LoyaltyCustomer lc2 = LoyaltyCustomerFactory.createLoyaltyCustomer(date,25.3);

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
        LoyaltyCustomer readLoyaltyCustomer1 = service.read(lc1.getLoyaltyCustomerId());
        LoyaltyCustomer readLoyaltyCustomer2 = service.read(lc2.getLoyaltyCustomerId());
        assertNotNull(readLoyaltyCustomer1);
        assertNotNull(readLoyaltyCustomer2);
        System.out.println("Read: \n" + readLoyaltyCustomer1 + "\n" + readLoyaltyCustomer2 + "\n");
    }

    @Test
    void c_update() {
        LoyaltyCustomer updatedLoyaltyCustomer = new LoyaltyCustomer.Builder().copy(lc1).setDiscounts(40.23).build();
        assertNotNull(service.update(updatedLoyaltyCustomer));
        System.out.println("Updated: \n" + updatedLoyaltyCustomer + "\n");
    }

    @Test
    void d_delete() {
        boolean deletedLoyaltyCustomer = service.delete(lc2.getLoyaltyCustomerId());
        assertTrue(deletedLoyaltyCustomer);
        System.out.println("Deleted successfully: \n" + deletedLoyaltyCustomer + "\n");
    }

    @Test
    void d_getAll() {
        System.out.println("All: \n" + service.getAll());
    }

}