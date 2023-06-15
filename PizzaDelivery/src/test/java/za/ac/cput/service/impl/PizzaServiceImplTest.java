package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Base;
import za.ac.cput.domain.Pizza;
import za.ac.cput.factory.PizzaFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
/* PizzaServiceImplTest.java
 Author: Timothy Lombard (220154856)
 Date: 9th June (last updated) 2023
*/
class PizzaServiceImplTest {

    private static PizzaServiceImpl service = PizzaServiceImpl.getService();

    private static Base b = PizzaFactory.createBase();
    private static Base b1 = PizzaFactory.createBase();


    private static Pizza pizza = PizzaFactory.buildPizza(b, "Vegetariana pizza", "Thin crust with high quality flour and fresh tomato sauce base and with high quality fresh vegetables.", Pizza.Size.SMALL, true, 40);
    private static Pizza pizza1 = PizzaFactory.buildPizza(b1, "Mushroom pizza", "Thick crust with high quality flour and fresh mushrooms and with double creamy extra cheese.", Pizza.Size.MEDIUM, false, 59);


    @Test
    public void a_create(){
        Pizza created = service.create(pizza);
        Pizza created1 = service.create(pizza1);
        System.out.println(created + "\n" + created1);
        assertNotNull(created);
        assertNotNull(created1);

    }

    @Test
    public void b_read(){
        Pizza reads = service.read(pizza.getPizzaId());
        Pizza reads1 = service.read(pizza1.getPizzaId());
        System.out.println(reads + "\n" + reads1);
        assertNotNull(reads);
        assertNotNull(reads1);
    }

    @Test
    public void c_update(){
        Pizza updated = new Pizza.Builder().copy(pizza).setSize(Pizza.Size.LARGE).setPrice(60).build();
        assertNotNull(service.update(updated));
        System.out.println(updated);
    }

    @Test
    public void d_delete(){
        boolean deleted = service.delete(pizza1.getPizzaId());
        assertTrue(deleted);
        System.out.println(true + " = deleted");
    }

    @Test
    public void e_getAll(){
        System.out.println(service.getAll());
    }

}