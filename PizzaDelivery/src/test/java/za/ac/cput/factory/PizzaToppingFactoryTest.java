package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import static org.junit.jupiter.api.Assertions.*;

/*
 PizzaToppingFactoryTest.java
 Author: Timothy Lombard (220154856)
 Date: 25th July (last updated) 2023
 */

class PizzaToppingFactoryTest {

    private static Base base = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THIN, Base.BaseTexture.CRISPY, 20);
    private static Pizzeria pizzeria = PizzeriaFactory.buildPizzaria("Hill Crest","300 Long St, Cape Town City Centre, 8000");
    private static Pizza pizza = PizzaFactory.createPizza(base, "Margherita pizza", "Thin crust with high quality flour and fresh tomato sauce and with creamy extra cheese.", Pizza.Size.SMALL, false, 55, pizzeria);
    private static Topping topping = ToppingFactory.buildTopping("Bacon", "spicy bacon", 6, 15);

    @Test
    public void success(){
        System.out.println(pizza.toString());
        System.out.println(topping.toString());
        assertNotNull(pizza);
        assertNotNull(topping);
    }

    @Disabled("Disabled test")
    @Test
    public void disabled(){
        System.out.println(pizza);
        System.out.println(topping);
        assertNotNull(pizza);
        assertNotNull(topping);
    }
}
