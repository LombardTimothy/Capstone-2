package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Pizza;
import za.ac.cput.domain.PizzaTopping;
import za.ac.cput.domain.Topping;
import za.ac.cput.factory.PizzaToppingFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
/* PizzaToppingServiceImpl.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
class PizzaToppingServiceImplTest {

    private static PizzaToppingServiceImpl service = PizzaToppingServiceImpl.getPizzaToppingService();
    private static Pizza p = PizzaToppingFactory.createPizza();
    private static Topping t = PizzaToppingFactory.createTopping();

    private static Pizza p1 = PizzaToppingFactory.createPizza();
    private static Topping t1 = PizzaToppingFactory.createTopping();

    private static PizzaTopping pt = PizzaToppingFactory.buildPizzaTopping(p, t);
    private static PizzaTopping pt1 = PizzaToppingFactory.buildPizzaTopping(p1, t1);

    @Test
    public void a_pizza_topping_create(){
        PizzaTopping created = service.create(pt);
        PizzaTopping created1 = service.create(pt1);
        System.out.println(created + "\n" + created1);
        assertNotNull(pt);
        assertNotNull(pt1);
    }

    @Test
    public void b_pizza_topping_read(){
        PizzaTopping read = service.read(pt.getPizzaId(), pt.getToppingId());
        PizzaTopping read1 = service.read(pt1.getPizzaId(), pt1.getToppingId());
        assertNotNull(read);
        assertNotNull(read1);
        System.out.println("Read " + read + "\n" + read1);
    }


    @Test
    public void d_pizza_topping_delete(){
        boolean deleted = service.delete(pt1.getPizzaId(), pt1.getToppingId());
        assertTrue(deleted);
        System.out.println("Delete " + true);//deleted
    }

    @Test
    public void e_pizza_topping_getAll(){
        System.out.println(service.getAll());

    }

}