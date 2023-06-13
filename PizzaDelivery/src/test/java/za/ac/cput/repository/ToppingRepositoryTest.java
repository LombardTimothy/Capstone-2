package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Topping;
import za.ac.cput.domain.Topping;
import za.ac.cput.factory.ToppingFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
/* ToppingRepositoryTest.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
class ToppingRepositoryTest {

    private static ToppingRepository repo = ToppingRepository.getToppingRepo();
    private static Topping t = ToppingFactory.buildTopping("Pepperoni", "spicy salami made from cured pork and beef seasoned with paprika or other chili pepper", 20, 11);
    private static Topping t1 = ToppingFactory.buildTopping("Rosemary", "The leaves are evergreen and needlelike in shape, and they produce the essential oil that gives rosemary its characteristic scent", 10, 8);

    @Test
    public void a_topping_create(){
        Topping created = repo.create(t);
        Topping created1 = repo.create(t1);
        System.out.println(created + "\n" + created1 );
        assertNotNull(t);
        assertNotNull(t1);

    }

    @Test
    public void b_topping_read(){
        Topping read = repo.read(t.getToppingId());
        Topping read1 = repo.read(t1.getToppingId());
        assertNotNull(read);
        assertNotNull(read1);
        System.out.println("Read " + read + "\n" + read1 );
    }

    @Test
    public void c_topping_update(){
        Topping updated = new Topping.Builder().copy(t).setToppingQuantity(13).build();
        assertNotNull(repo.update(updated));
        System.out.println(updated);
    }

    @Test
    public void d_topping_delete(){
        boolean deleted = repo.delete(t1.getToppingId());
        assertTrue(deleted);
        System.out.println("Delete " + true);//deleted
    }

    @Test
    public void e_topping_getAll(){
        System.out.println(repo.getAll());

    }


}