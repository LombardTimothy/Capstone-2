package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Pizza;
import za.ac.cput.domain.PizzaTopping;
import za.ac.cput.domain.Topping;

import static org.junit.jupiter.api.Assertions.*;
/* PizzaToppingFactoryTest.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
class PizzaToppingFactoryTest {

    private static Pizza p = PizzaToppingFactory.createPizza();
    private static Topping t = PizzaToppingFactory.createTopping();

    private static PizzaTopping pt = PizzaToppingFactory.buildPizzaTopping(p, t);

    @Test
    public void success(){
        System.out.println(pt.toString());
        assertNotNull(pt);
    }

    @Disabled("Disabled test")
    @Test
    public void disabled(){
        System.out.println(pt);
        assertNotNull(pt);
    }

}