package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Pizzeria;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.factory.DriverFactory;
import za.ac.cput.factory.PizzeriaFactory;
import za.ac.cput.factory.VehicleFactory;
import static org.junit.jupiter.api.Assertions.*;

/*DriverServiceImplTest.java
Author: Azhar Allie Mohammed(217250513)
Date: 11/06/2023
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class DriverServiceImplTest {
    @Autowired
    private DriverServiceImpl service;
    private static Vehicle vehicle1 = VehicleFactory.createVehicle("Lyft Scooter", "Lyft", "Next gen Lyft Scooter", "2022", "Plain white");
    private static Vehicle vehicle2 = VehicleFactory.createVehicle("Nissan", "Nissian Note", "Nissian Note Subcompact", "2005", "Light grey");
    private static Pizzeria pizzeria = PizzeriaFactory.buildPizzaria("Hill Crest","Hotel Transalvania");
    private static Driver driver1 = DriverFactory.buildDriver("Zoe", "Samuels", "083-733-0821", "ZoeS@gmail.com", vehicle1, pizzeria);
    private static Driver driver2 = DriverFactory.buildDriver("Max", "Edwards", "036-836-1378", "MaxEdwards@gmail.com", vehicle2, pizzeria);

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
        Driver read1 = service.read(String.valueOf(driver1.getEmpId()));
        Driver read2 = service.read(String.valueOf(driver2.getEmpId()));
        System.out.println(read1 + "\n" + read2);
        assertNotNull(driver1);
        assertNotNull(driver2);
    }

    @Test
    public void c_update() {
        Driver updated = (Driver) new Driver.Builder().copy(driver1).setEmail("SZoe@gmail.com").build();
        assertNotNull(service.update(updated));
        System.out.println(updated);
    }
    @Disabled
    @Test
    public void d_delete() {
        boolean delete = service.delete(String.valueOf(driver2.getEmpId()));
        assertTrue(delete);
        System.out.println(true + "= deleted ");
    }

    @Test
    void getAll() {
        System.out.println(service.getAll());
    }
}
