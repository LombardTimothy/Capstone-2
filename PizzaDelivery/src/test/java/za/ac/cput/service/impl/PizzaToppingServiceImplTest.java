package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/*
   PizzaToppingServiceImplTest.java
   Author: Timothy Lombard (220154856)
   Date: 4th August (last updated) 2023
*/

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class PizzaToppingServiceImplTest {

    @Autowired
    private PizzaServiceImpl pizzaService;
    @Autowired
    private ToppingServiceImpl toppingService;

    private static Base base = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THIN, Base.BaseTexture.CRISPY, 20);
    private static Pizzeria pizzeria = PizzeriaFactory.buildPizzaria("Hill Crest","300 Long St, Cape Town City Centre, 8000");
    private static Pizza pizza = PizzaFactory.createPizza(base, "Margherita pizza", "Thin crust with high quality flour and fresh tomato sauce and with creamy extra cheese.", Pizza.Size.SMALL, false, 87, pizzeria);
    private static Topping topping = ToppingFactory.buildTopping("Pepperoni", "spicy salami made from cured pork and beef seasoned with paprika or other chili pepper", 20, 24);

    @Test
    public void a_create(){
        Topping toppingCreated1 = toppingService.create(topping);
        Set<Topping> toppings = new HashSet<>();
        toppings.add(toppingCreated1);
        pizza.setToppings(toppings);

        Pizza pizzaCreated1 = pizzaService.create(pizza);
        assertNotNull(pizzaCreated1.getPizzaId());
        assertEquals(pizza.getName(), pizzaCreated1.getName());
        assertTrue(pizzaCreated1.getToppings().contains(toppingCreated1));
        pizzaCreated1.getToppings().forEach(System.out::println);
        System.out.println(pizzaCreated1);
    }

    @Test
    public void b_read(){
        Topping readToppingId1 = toppingService.read(topping.getToppingId());
        Pizza readPizza1 = pizzaService.read(pizza.getPizzaId());
        assertNotNull(readToppingId1);
        assertNotNull(readPizza1);
        System.out.println(readToppingId1  + "\n" + readPizza1);
    }

    @Test
    public void c_update() {
        Topping newTopping = new Topping.Builder().copy(topping).setQuantity(14).build();
        Topping updatedTopping = toppingService.update(newTopping);
        assertEquals(newTopping.getQuantity(), updatedTopping.getQuantity());
        System.out.println(updatedTopping);
    }

    @Disabled
    @Test
    public void d_delete(){
        boolean deletePizza = pizzaService.delete(pizza.getPizzaId());
        assertTrue(deletePizza);
        System.out.println(true + "Pizza deleted");
    }

    @Test
    public void e_getAll(){
        System.out.println(toppingService.getAll());
    }

    @Test
    public void f_getAll(){
        System.out.println(pizzaService.getAll());
    }
}
