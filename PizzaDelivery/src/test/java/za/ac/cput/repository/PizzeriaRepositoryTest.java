package za.ac.cput.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Pizzeria;
import za.ac.cput.factory.PizzeriaFactory;
/*
   PizzeriaRepositoryTest.java
   Entity for the PizzeriaRepositoryTest
   Author: Keenan Meyer (220194920)
   Date: 03th April 2023
*/
//@TestMethodOrder(MethodOrderer.MethodName.class)
/*
public class PizzeriaRepositoryTest {

    private static PizzeriaRepository repo = PizzeriaRepository.getRepository();

    private static Pizzeria pizzeria = PizzeriaFactory.buildRestaurant(
            "Grancho",
            25,
            true);

    private static Pizzeria pizzeria2 = PizzeriaFactory.buildRestaurant(
            "Grancho & Sons",
            22,
            true);

    private static Pizzeria pizzeria3 = PizzeriaFactory.buildRestaurant(
            "GrangerBay",
            15,
            false);


    @Test
    public void a_Restaurant_create(){
        Pizzeria created = repo.create(pizzeria);
        Pizzeria created1 = repo.create(pizzeria2);
        Pizzeria created2 = repo.create(pizzeria3);
        System.out.println(created + "\n" + created1 + "\n" + created2);
        assertNotNull(pizzeria);
        assertNotNull(pizzeria2);
        assertNotNull(pizzeria3);
    }

    @Test
    public void b_Restaurant_read(){
        Pizzeria read = repo.read(pizzeria.getRestaurantID());
        Pizzeria read1 = repo.read(pizzeria2.getRestaurantID());
        Pizzeria read2 = repo.read(pizzeria3.getRestaurantID());
        assertNotNull(read);
        assertNotNull(read1);
        assertNotNull(read2);
        System.out.println("Read " + read + "\n" + read1 + "\n" + read2);
    }

    @Test
    public void c_Restaurant_update(){
        Pizzeria.Builder builder2 = new Pizzeria.Builder();
        builder2.copy(pizzeria);
        //builder2.setRestaurantName("Granger & Moms");
        builder2.setIsOpen(true);
        builder2.setNoOfEmp(10);
        Pizzeria updated = builder2.build();
        assertNotNull(repo.update(updated));
        System.out.println(updated);
    }

    @Test
    public void d_Restaurant_delete(){
        boolean deleted = repo.delete(pizzeria.getRestaurantID());
        assertTrue(deleted);
        System.out.println("Delete " + true);//deleted
    }

    @Test
    public void e_Restaurant_getAll(){
        System.out.println(repo.getAll());

    }
}

 */

