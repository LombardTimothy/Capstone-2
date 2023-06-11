package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Restaurant;
import za.ac.cput.factory.RestaurantFactory;

import static org.junit.jupiter.api.Assertions.*;
/*
 * RestaurantServiceImplTest.java
 * Service Test for the Restaurant
 * Author: Keenan Meyer - 220194920
 * Date: 09 June 2023
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
class RestaurantServiceImplTest {
    private static Restaurant restaurant = RestaurantFactory.buildRestaurant(
            "Grancho",
            25,
            true);

    private static Restaurant restaurant2 = RestaurantFactory.buildRestaurant(
            "Grancho & Sons",
            22,
            true);

    private static Restaurant restaurant3 = RestaurantFactory.buildRestaurant(
            "GrangerBay",
            15,
            false);
    private static RestaurantServiceImpl service = RestaurantServiceImpl.getService();
    @Test
    void a_create() {
        Restaurant created = service.create(restaurant);
        Restaurant created1 = service.create(restaurant2);

        System.out.println(created);
        System.out.println(created1);

        assertNotNull(created);
        assertNotNull(created1);
    }

    @Test
    void b_read() {
        Restaurant read = service.read(restaurant.getRestaurantID());
        Restaurant read2 = service.read(restaurant2.getRestaurantID());

        System.out.println(restaurant);
        System.out.println(restaurant2);

        assertNotNull(restaurant);
        assertNotNull(restaurant2);
    }


    @Test
    void c_update() {
        Restaurant updatedRestaurant = new Restaurant
                .Builder()
                .copy(restaurant2)
                .setRestaurantName("Tigers and sons")
                .setNoOfEmp(17)
                .setIsOpen(false)
                .build();
        assertNotNull(service.update(updatedRestaurant));
        System.out.println(updatedRestaurant);
    }


    @Test
    void d_delete() {
        boolean deleted = service.delete(restaurant.getRestaurantID());
        assertTrue(deleted);
        System.out.println(true + " = deleted");
    }

    @Test
    void e_getAll() {
        System.out.println(service.getAll());
    }
}