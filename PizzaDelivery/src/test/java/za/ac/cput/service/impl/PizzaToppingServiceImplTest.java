package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Base;
import za.ac.cput.domain.Pizza;
import za.ac.cput.domain.PizzaTopping;
import za.ac.cput.domain.Topping;
import za.ac.cput.factory.BaseFactory;
import za.ac.cput.factory.PizzaFactory;
import za.ac.cput.factory.PizzaToppingFactory;
import za.ac.cput.factory.ToppingFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
/* PizzaToppingServiceImpl.java
 Author: Timothy Lombard (220154856)
 Date: 21st July (last updated) 2023
*/
@SpringBootTest
class PizzaToppingServiceImplTest {

    @Autowired
    private PizzaToppingServiceImpl service;

    private static Base base = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THIN, Base.BaseTexture.CRISPY, 20);
    private static Pizza pizza = PizzaFactory.buildPizza(base, "Margherita pizza", "Thin crust with high quality flour and fresh tomato sauce and with creamy extra cheese.", Pizza.Size.SMALL, false, 55);
    private static Topping topping = ToppingFactory.buildTopping("Pepperoni", "spicy salami made from cured pork and beef seasoned with paprika or other chili pepper", 20, 11);

    private static PizzaTopping pt = PizzaToppingFactory.buildPizzaTopping(pizza, topping);

    @Test
    public void a_create(){
        PizzaTopping created  = service.create(pt);
        assertEquals(pt.getPizza(), created.getPizza());
        assertEquals(pt.getTopping(), created.getTopping());
        System.out.println(created);

    }
/*
    @Disabled
    @Test
    public void b_read(){
        PizzaTopping read = service.read();
        assertNotNull(read);
        System.out.println(read);

    }

 */


    @Disabled
    @Test
    public void d_delete(){

    }

    @Test
    public void getAll(){
        System.out.println(service.getAll());
    }



    }

