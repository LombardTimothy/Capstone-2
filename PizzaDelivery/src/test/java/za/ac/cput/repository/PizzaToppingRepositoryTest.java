package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.PizzaTopping;
import za.ac.cput.factory.PizzaToppingFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
/* PizzaToppingRepositoryTest.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
class PizzaToppingRepositoryTest {

    private static PizzaToppingRepository repo = PizzaToppingRepository.getRepo();
    private static PizzaTopping pt = PizzaToppingFactory.buildPizzaTopping();
    private static PizzaTopping pt1 = PizzaToppingFactory.buildPizzaTopping();

    @Test
    public void a_pizza_topping_create(){
        PizzaTopping created = repo.create(pt);
        PizzaTopping created1 = repo.create(pt1);
        System.out.println(created + "\n" + created1);
        assertNotNull(pt);
        assertNotNull(pt1);
    }

    @Test
    public void b_pizza_topping_read(){
        PizzaTopping read = repo.read(pt.getPizzaId(), pt.getToppingId());
        PizzaTopping read1 = repo.read(pt1.getPizzaId(), pt1.getToppingId());
        assertNotNull(read);
        assertNotNull(read1);
        System.out.println("Read " + read + "\n" + read1);
    }


    @Test
    public void d_pizza_topping_delete(){
        boolean deleted = repo.delete(pt1.getPizzaId(), pt1.getToppingId());
        assertTrue(deleted);
        System.out.println("Delete " + true);//deleted
    }

    @Test
    public void e_pizza_topping_getAll(){
        System.out.println(repo.getAll());

    }




}