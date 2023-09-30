package za.ac.cput.service.impl;
/*VehicleServiceImplTest.java
Author: Azhar Allie Mohammed(217250513)
Date: 11/06/2023

 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Chef;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.factory.VehicleFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class VehicleServiceImplTest {
    @Autowired
    private VehicleServiceImpl service;
    private static Vehicle vehicle1 = VehicleFactory.createVehicle("Toyota", "Starlet", "Toyota Starrlet Hatchback", "2020", "White");
    private static Vehicle vehicle2 = VehicleFactory.createVehicle("Lyft Scooter", "Lyft", "Next gen Lyft Scooter", "2023", "Metallic silver");


    @Test
    void a_create() {
        Vehicle created1 = service.create(vehicle1);
        Vehicle created2 =  service.create(vehicle2);
        System.out.println(created1 + "\n" + created2);
        assertNotNull(created1);
        assertNotNull(created2);
    }

    @Test
    void b_read() {
        Vehicle read1 = service.read(String.valueOf(vehicle1.getVehicleId()));
        Vehicle read2 = service.read(String.valueOf(vehicle2.getVehicleId()));
        System.out.println(read1 + "\n" + read2);
        assertNotNull(read1);
        assertNotNull(read2);
    }

    @Test
    void c_update() {
        Vehicle updated = new Vehicle.Builder().copy(vehicle1).setColour("Super white").build();
        assertNotNull(service.update(updated));
        System.out.println(updated);
    }

    @Test
    void d_delete() {
        boolean delete = service.delete(String.valueOf(vehicle2.getVehicleId()));
        assertTrue(delete);
        System.out.println(true + "= deleted");
    }

    @Test
    void getAll() {
        System.out.println(service.getAll());
    }
}

