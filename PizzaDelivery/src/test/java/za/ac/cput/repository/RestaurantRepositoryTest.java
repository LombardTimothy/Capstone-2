package za.ac.cput.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Restaurant;
import za.ac.cput.factory.RestaurantFactory;
/*
   RestaurantRepositoryTest.java
   Entity for the RestaurantRepositoryTest
   Author: Keenan Meyer (220194920)
   Date: 03th April 2023
*/
@TestMethodOrder(MethodOrderer.MethodName.class)

public class RestaurantRepositoryTest {

    private static RestaurantRepository repo = RestaurantRepository.getRepository();

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


    @Test
    public void a_Restaurant_create(){
        Restaurant created = repo.create(restaurant);
        Restaurant created1 = repo.create(restaurant2);
        Restaurant created2 = repo.create(restaurant3);
        System.out.println(created + "\n" + created1 + "\n" + created2);
        assertNotNull(restaurant);
        assertNotNull(restaurant2);
        assertNotNull(restaurant3);
    }

    @Test
    public void b_Restaurant_read(){
        Restaurant read = repo.read(restaurant.getRestaurantID());
        Restaurant read1 = repo.read(restaurant2.getRestaurantID());
        Restaurant read2 = repo.read(restaurant3.getRestaurantID());
        assertNotNull(read);
        assertNotNull(read1);
        assertNotNull(read2);
        System.out.println("Read " + read + "\n" + read1 + "\n" + read2);
    }

    @Test
    public void c_Restaurant_update(){
        Restaurant.Builder builder2 = new Restaurant.Builder();
        builder2.copy(restaurant);
        //builder2.setRestaurantName("Granger & Moms");
        builder2.setIsOpen(true);
        builder2.setNoOfEmp(10);
        Restaurant updated = builder2.build();
        assertNotNull(repo.update(updated));
        System.out.println(updated);
    }

    @Test
    public void d_Restaurant_delete(){
        boolean deleted = repo.delete(restaurant.getRestaurantID());
        assertTrue(deleted);
        System.out.println("Delete " + true);//deleted
    }

    @Test
    public void e_Restaurant_getAll(){
        System.out.println(repo.getAll());

    }
}

