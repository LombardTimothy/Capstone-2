package za.ac.cput.repository;
/*
DriverRepositoryTest.java
Author: Azhar Allie Mohammed (217250513)
Date: 08/04/2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Driver;
import za.ac.cput.factory.DriverFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class DriverRepositoryTest {
    private static DriverRepository repository = DriverRepository.getRepository();
    private static Driver driver = DriverFactory.createDriver();

    @Test
    void a_create() {
        Driver created = repository.create(driver);
        assertEquals(driver.getDriverId(), created.getDriverId());
        System.out.println("Created" + created);
    }

    @Test
    void b_read() {
        Driver read = repository.read(driver.getDriverId());
        assertNotNull(read);
        System.out.println("Read" + read);
    }

    @Test
    void c_update() {
        Driver updated = new Driver.Builder().copy(driver).build();
        assertNotNull(repository.update(updated));
        System.out.println(updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(driver.getDriverId());
        assertTrue(success);
        System.out.println("Deleted" + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show All: ");
        System.out.println(repository.getAll());
    }
}