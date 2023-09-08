package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Chef;
import za.ac.cput.domain.Pizzeria;

import static org.junit.jupiter.api.Assertions.*;

/*
* ChefFactoryTest.java
* Author: Dawood Kamalie  (220147760)
* Date: 8/4/2023
* */
class ChefFactoryTest {
    private static Pizzeria pizzeria = PizzeriaFactory.buildRestaurant("Hill Crest","Hotel Transalvania");
    @Test
    void createChef() {
        Chef chef = ChefFactory.createChef("Dawood", "Kamalie", "973-926-7412", "Dawood@gmail.com", "Head pizza chef", "5 years", pizzeria);
        System.out.println(chef);
        assertNotNull(chef);
    }
}