package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Chef;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.ChefFactory;

import static org.junit.jupiter.api.Assertions.*;

/* ChefServiceImplTest.java
 Author: Dawood Kamalie (220147760)
 Date: 11th June (last updated) 2023
*/
@TestMethodOrder(MethodOrderer.MethodName.class)
class ChefServiceImplTest {

    private static ChefServiceImpl service;
    private static Chef chef1 = ChefFactory.createChef("Francois", "Jacob", "DuToit", "French", "Sous Chef");
    private static Chef chef2 = ChefFactory.createChef("Louis", "Basil", "Russoux", "Algerian", "Head Chef");

    @Test
    public void a_create() {
        Chef created1 = service.create(chef1);
        Chef created2 =  service.create(chef2);
        System.out.println(created1 + "\n" + created2);
        assertNotNull(created1);
    }

    @Test
    public void b_read() {
        Employee read1 = service.read(chef1.getChefId());
        Employee read2 = service.read(chef2.getChefId());
        System.out.println(read1 + "\n" + read2);
        assertNotNull(read1);
        assertNotNull(read2);
    }

    @Test
    public void c_update() {
        Chef updated = new Chef.Builder().copy(chef1).setEmpId("204").setChefName("Delouise").setChefSurname("Rummelo").setChefId("004").setNationality("French").setCulinaryExperience("Sous Chef").build();
        assertNotNull(service.update(updated));
        System.out.println(updated);
    }

    @Test
    public void d_delete() {
        boolean deleted = service.delete(chef1.getChefId());
        assertTrue(deleted);
        System.out.println(true + " = deleted");
    }

    @Test
    public void getAll() {
        System.out.println(service.getAll());
    }

}