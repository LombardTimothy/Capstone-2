package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import static org.junit.jupiter.api.Assertions.*;
/* PizzaToppingFactoryTest.java
 Author: Timothy Lombard (220154856)
 Date: 25th July (last updated) 2023
*/
class PizzaToppingFactoryTest {

    private static Base base = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THIN, Base.BaseTexture.CRISPY, 20);
    private static Pizzeria pizzeria = PizzeriaFactory.buildPizzaria("Hill Crest","Hotel Transalvania");
    private static Pizza pizza = PizzaFactory.createPizza(base, "Margherita pizza", "Thin crust with high quality flour and fresh tomato sauce and with creamy extra cheese.", Pizza.Size.SMALL, false, 55, pizzeria);
    private static Topping topping = ToppingFactory.buildTopping("Pepperoni", "spicy salami made from cured pork and beef seasoned with paprika or other chili pepper", 20, 11);

    private static PizzaTopping pt = PizzaToppingFactory.buildPizzaTopping(pizza, topping);

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