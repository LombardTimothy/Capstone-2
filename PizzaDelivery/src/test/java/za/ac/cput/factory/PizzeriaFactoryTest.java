package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Pizzeria;
import static org.junit.jupiter.api.Assertions.assertNotNull;
class PizzeriaFactoryTest {
    @Test
    void buildRestaurant() {
        Pizzeria pizzeria = PizzeriaFactory.buildRestaurant("Hill Crest","Hotel Transalvania");
        System.out.println(pizzeria.toString());
        assertNotNull(pizzeria);
    }
}
