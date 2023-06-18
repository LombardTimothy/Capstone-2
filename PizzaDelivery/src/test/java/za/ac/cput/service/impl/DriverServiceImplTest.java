package za.ac.cput.service.impl;
/*DriverServiceImplTest.java
Author: Azhar Allie Mohammed(217250513)
Date: 11/06/2023

 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Driver;
import za.ac.cput.factory.DriverFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class DriverServiceImplTest {
    private static DriverServiceImpl service = DriverServiceImpl.getService();
    private static Driver driver1 = DriverFactory.createDriver("501","255","zain","G");
    private static Driver driver2 = DriverFactory.createDriver("502","456","Josh","J");
    @Test
    public void a_create() {
        Driver create1 = service.create(driver1);
        Driver create2 = service.create(driver2);
        System.out.println(create1 + "\n" + create2);
        assertNotNull(create1);
        assertNotNull(create2);
    }

    @Test
    public void b_read() {
        Driver read1 = service.read(driver1.getDriverId());
        Driver read2 = service.read(driver2.getDriverId());
        System.out.println(read1 + "\n" + read2);
        assertNotNull(driver1);
        assertNotNull(driver2);
    }

    @Test
    public void c_update() {
        Driver updated = new Driver.Builder().copy(driver1).setDriverId("511").build();
        assertNotNull(service.update(updated));
        System.out.println(updated);
    }

    @Test
    public void d_delete() {
        boolean delete = service.delete(driver1.getDriverId());
        assertTrue(delete);
        System.out.println(true + "= deleted ");
    }

    @Test
    void getAll() {
        System.out.println(service.getAll());
    }
}