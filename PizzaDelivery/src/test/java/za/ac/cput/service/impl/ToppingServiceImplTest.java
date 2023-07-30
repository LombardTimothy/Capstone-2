package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Topping;
import za.ac.cput.factory.ToppingFactory;
/* ToppingServiceImplTest.java
 Author: Timothy Lombard (220154856)
 Date: 30th July (last updated) 2023
*/

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class ToppingServiceImplTest {

    @Autowired
    private ToppingServiceImpl service;

    private static Topping t = ToppingFactory.buildTopping("Bacon", "spicy bacon", 6, 15);
    @Test
    public void a_create(){
        Topping created1 = service.create(t);
        assertEquals(t.getToppingId(), created1.getToppingId());
        System.out.println( created1);

    }

    @Test
    public void b_read(){

        Topping read1 = service.read(t.getToppingId());
        assertNotNull(t);
        System.out.println( read1);

    }

    @Test
    public void c_update(){
        Topping newTopping = new Topping.Builder().copy(t).setQuantity(14).build();
        Topping updated = service.update(newTopping);
        assertEquals(newTopping.getQuantity(), updated.getQuantity());
        System.out.println(updated);


    }

    @Disabled
    @Test
    public void d_delete(){
        boolean deleted = service.delete(t.getToppingId());
        assertTrue(deleted);
        System.out.println(true + " = deleted");
    }

    @Test
    public void getAll(){
        System.out.println(service.getAll());
    }



}