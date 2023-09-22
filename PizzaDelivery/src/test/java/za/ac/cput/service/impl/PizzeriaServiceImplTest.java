package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Pizzeria;
import za.ac.cput.factory.PizzeriaFactory;
import static org.junit.jupiter.api.Assertions.*;
/*
 * PizzeriaServiceImplTest.java
 * Service Test for the Pizzeria
 * Author: Keenan Meyer - 220194920
 * Date: 09 June 2023
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class PizzeriaServiceImplTest {
    private static Pizzeria pizzeria = PizzeriaFactory.buildPizzaria(
            "Hill Crest","Hotel Transylvania");

    @Autowired
    private PizzeriaServiceImpl service;
    @Test
    void a_create() {
        Pizzeria created = service.create(pizzeria);

        System.out.println(created);

        assertNotNull(created);
    }

    @Test
    void b_read() {
        Pizzeria read = service.read(String. valueOf(pizzeria.getPizzeriaID()));
        Pizzeria read2 = service.read(String. valueOf(pizzeria.getPizzeriaID()));

        System.out.println(pizzeria);
        assertNotNull(pizzeria);
    }
    @Test
    void c_update() {
        Pizzeria newPizzeria = new Pizzeria
                .Builder()
                .copy(pizzeria)
                .setLocation("Hotel Transylvania 2")
                .build();
        Pizzeria updated = service.update(newPizzeria);

        assertEquals(updated.getPizzariaAlias(),newPizzeria.getPizzariaAlias());
        assertNotNull(service.update(newPizzeria));
        System.out.println(newPizzeria);
    }
    /*
    @Test
    void d_delete() {
        boolean deleted = service.delete(pizzeria.getRestaurantID());
        assertTrue(deleted);
        System.out.println(true + " = deleted");
    }
     */
    @Test
    void e_getAll() {
        System.out.println(service.getAll());
    }
}

