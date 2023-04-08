package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Pizza;
import za.ac.cput.factory.PizzaFactory;

import static org.junit.jupiter.api.Assertions.*;


    @TestMethodOrder(MethodOrderer.MethodName.class)//runs the test cases in alphabetical order

/* PizzaRepositoryTest.java
 Author: Timothy Lombard (220154856)
 Date: 6th April (last updated) 2023
*/

    class PizzaRepositoryTest {

        private static PizzaRepository repo = PizzaRepository.getRepo();
        private static Pizza pizza = PizzaFactory.buildPizza("Vegetariana pizza", "Thin crust with high quality flour and fresh tomato sauce base and with high quality fresh vegetables.", "Small", true, 32);
        private static Pizza pizza1 = PizzaFactory.buildPizza("Mushroom pizza", "Thick crust with high quality flour and fresh mushrooms and with double creamy extra cheese.", "Medium", false, 48);
        private static Pizza pizza2 = PizzaFactory.buildPizza("Margherita pizza", "Thin crust with high quality flour and fresh tomato sauce and with creamy extra cheese.", "Small", false, 35);





        @Test
        public void a_pizza_create(){
            Pizza created = repo.create(pizza);
            Pizza created1 = repo.create(pizza1);
            Pizza created2 = repo.create(pizza2);
            System.out.println(created + "\n" + created1 + "\n" + created2);
            assertNotNull(pizza);
            assertNotNull(pizza1);
            assertNotNull(pizza2);
        }

        @Test
        public void b_pizza_read(){
            Pizza read = repo.read(pizza.getPizzaId());
            Pizza read1 = repo.read(pizza1.getPizzaId());
            Pizza read2 = repo.read(pizza2.getPizzaId());
            assertNotNull(read);
            assertNotNull(read1);
            assertNotNull(read2);
            System.out.println("Read " + read + "\n" + read1 + "\n" + read2);
        }

        @Test
        public void c_pizza_update(){
            Pizza updated = new Pizza.Builder().copy(pizza2).setItemDescription("Thick crust and thick base with high quality fresh tomato sauce and with extra double creamy cheese").setPrice(45).build();
            assertNotNull(repo.update(updated));
            System.out.println(updated);
        }

        @Test
        public void d_pizza_delete(){
            boolean deleted = repo.delete(pizza.getPizzaId());
            assertTrue(deleted);
            System.out.println("Delete " + true);//deleted
        }

        @Test
        public void e_pizza_getAll(){
            System.out.println(repo.getAll());

        }

    }

