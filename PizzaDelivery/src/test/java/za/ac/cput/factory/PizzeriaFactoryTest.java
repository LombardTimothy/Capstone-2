package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Pizzeria;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PizzeriaFactoryTest {
    @Test
    void buildPizzaria() {
        Pizzeria pizzeria = PizzeriaFactory.buildPizzaria("Hill Crest","Hotel Transylvania");
        System.out.println(pizzeria.toString());
        assertNotNull(pizzeria);
    }
}
