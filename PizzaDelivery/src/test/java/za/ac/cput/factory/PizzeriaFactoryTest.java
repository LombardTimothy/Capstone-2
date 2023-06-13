package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Pizzeria;
import static org.junit.jupiter.api.Assertions.assertNotNull;
class PizzeriaFactoryTest {
    @Test
    void buildRestaurant() {
        Pizzeria pizzeria = PizzeriaFactory.buildRestaurant("Hill Crest",12,  true);
        System.out.println(pizzeria.toString());
        assertNotNull(pizzeria);
    }
}
