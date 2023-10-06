package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Chef;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Pizzeria;
import za.ac.cput.factory.ChefFactory;
import za.ac.cput.factory.PizzeriaFactory;

import static org.junit.jupiter.api.Assertions.*;

/* ChefServiceImplTest.java
 Author: Dawood Kamalie (220147760)
 Date: 11th June (last updated) 2023
*/


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class ChefServiceImplTest {
@Autowired
    private ChefServiceImpl service;
    private static Pizzeria pizzeria = PizzeriaFactory.buildPizzaria("Hill Crest","Hotel Transalvania");
    private static Chef chef1 = ChefFactory.buildChef("Francois", "Jacob", "011-746-0962", "JacobsF@gmail.com", "Sous chef", "10 years", pizzeria);
    private static Chef chef2 = ChefFactory.buildChef("Louis", "Basil", "086-119-0902", "Louis@gmail.com", "Head chef", "15 years", pizzeria);


    @Test
    public void a_create() {
        Chef created1 = service.create(chef1);
        Chef created2 =  service.create(chef2);
        System.out.println(created1 + "\n" + created2);
        assertNotNull(created1);
        assertNotNull(created2);

    }

    @Test
    public void b_read() {
        Employee read1 = service.read(String.valueOf(chef1.getEmpId()));
        Employee read2 = service.read(String.valueOf(chef2.getEmpId()));
        System.out.println(read1 + "\n" + read2);
        assertNotNull(read1);
        assertNotNull(read2);
    }

    @Test
    public void c_update() {
        Chef updated = new Chef.Builder().copy(chef2).setCulinaryExperience("16 years").build();
        assertNotNull(service.update(updated));
        System.out.println(updated);
    }
@Disabled
    @Test
    public void d_delete() {
        boolean deleted = service.delete(String.valueOf(chef1.getEmpId()));
        assertTrue(deleted);
        System.out.println(true + " = deleted");
    }

    @Test
    public void getAll() {
        System.out.println(service.getAll());
    }

}

