package za.ac.cput.repository;
/*
VehicleRepositoryTest.java
Author: Azhar Allie Mohammed (217250513)
Date: 08/04/2023
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.factory.VehicleFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class VehicleRepositoryTest {
private static VehicleRepository repository = VehicleRepository.getRepository();
private static Vehicle vehicle = VehicleFactory.createVehicle("Scooter");
@Test
    void a_create(){
    Vehicle created = repository.create(vehicle);
    assertEquals(vehicle.getVehicleId() , created.getVehicleId());
    System.out.println("Created: " + created);
}
    @Test
    void b_read() {
        Vehicle read = repository.read(vehicle.getVehicleId());
        assertNotNull(read);
        System.out.println("Read" + read);
    }

    @Test
    void c_update() {
        Vehicle updated = new Vehicle.Builder().copy(vehicle).setVehicleType("BMW").build();
        assertNotNull(repository.update(updated));
        System.out.println(updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(vehicle.getVehicleId());
        assertTrue(success);
        System.out.println("Deleted" + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show All: ");
        System.out.println(repository.getAll());
    }
}