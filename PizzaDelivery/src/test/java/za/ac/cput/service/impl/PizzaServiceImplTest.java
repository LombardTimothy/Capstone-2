package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Base;
import za.ac.cput.domain.Pizza;
import za.ac.cput.domain.Pizzeria;
import za.ac.cput.factory.BaseFactory;
import za.ac.cput.factory.PizzaFactory;
import za.ac.cput.factory.PizzeriaFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
/* PizzaServiceImplTest.java
 Author: Timothy Lombard (220154856)
 Date: 4th August (last updated) 2023
*/
@SpringBootTest
class PizzaServiceImplTest {

   @Autowired
    private PizzaServiceImpl service;


    private static Base base = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THIN, Base.BaseTexture.CRISPY, 20);
    private static Pizzeria pizzeria = PizzeriaFactory.buildPizzaria("Hill Crest","Hotel Transalvania");
    private static Pizza pizza = PizzaFactory.createPizza(base, "Margherita pizza", "Thin crust with high quality flour and fresh tomato sauce and with creamy extra cheese.", Pizza.Size.SMALL, false, 60, pizzeria);

    @Test
    public void a_create(){
        Pizza created  = service.create(pizza);
        assertEquals(pizza.getPizzaId(), created.getPizzaId());
        System.out.println(created);

    }

    @Test
    public void b_read(){
        Pizza read = service.read(pizza.getPizzaId());
        assertNotNull(read);
        System.out.println(read);

    }

    @Test
    public void c_update(){
        Pizza newPizza = new Pizza.Builder().copy(pizza).setPrice(60).build();
        Pizza updated = service.update(newPizza);
        assertEquals(newPizza.getPrice(), updated.getPrice());
        System.out.println(updated);


    }
    @Disabled
    @Test
    public void d_delete(){
        boolean deleted = service.delete(pizza.getPizzaId());
        assertTrue(deleted);
        System.out.println(true + " = deleted");

    }

    @Test
    public void getAll(){
        System.out.println(service.getAll());
    }





}