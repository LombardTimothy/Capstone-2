package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
/* PizzaToppingServiceImpl.java
 Author: Timothy Lombard (220154856)
 Date: 4th August (last updated) 2023
*/
@SpringBootTest
class PizzaToppingServiceImplTest {

    @Autowired
    private PizzaToppingServiceImpl service;

    private static Base base = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THIN, Base.BaseTexture.CRISPY, 20);
    private static Pizzeria pizzeria = PizzeriaFactory.buildPizzaria("Hill Crest","Hotel Transalvania");
    private static Pizza pizza = PizzaFactory.createPizza(base, "Margherita pizza", "Thin crust with high quality flour and fresh tomato sauce and with creamy extra cheese.", Pizza.Size.SMALL, false, 87, pizzeria);
    private static Topping topping = ToppingFactory.buildTopping("Pepperoni", "spicy salami made from cured pork and beef seasoned with paprika or other chili pepper", 20, 24);

    private static PizzaTopping pt = PizzaToppingFactory.buildPizzaTopping(pizza, topping);

    @Test
    public void a_create(){
        PizzaTopping created  = service.create(pt);
        assertEquals(pt.getPizza(), created.getPizza());
        assertEquals(pt.getTopping(), created.getTopping());
        System.out.println(created);

    }

    @Test
    public void b_read(){

        final Pizza pizzaId = pt.getPizza();
        final Topping toppingId = pt.getTopping();
        System.out.println(pizzaId + "\n" + toppingId);
        System.out.println(service.readPizzaIdAndToppingId(pizzaId, toppingId));

    }
    @Disabled
    @Test
    public void d_delete(){
        final Pizza pizzaId = pt.getPizza();
        final Topping toppingId = pt.getTopping();
        service.deletePT(pizzaId, toppingId);
        System.out.println("Deleted");

    }


    @Test
    public void getAll(){
        System.out.println(service.getAll());
    }



    }

