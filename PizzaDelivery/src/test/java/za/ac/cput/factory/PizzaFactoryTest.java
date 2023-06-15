package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Pizza;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


/* PizzaFactoryTest.java
 Author: Timothy Lombard (220154856)
 Date: 5th April (last updated) 2023
*/

    class PizzaFactoryTest {

        @Test
        public void pizza_success_test(){
            Pizza menu = PizzaFactory.buildPizza("Margherita pizza", "Thin crust with high quality flour and fresh tomato sauce and with creamy extra cheese.", Pizza.Size.MEDIUM, false, 65);
            System.out.println(menu.toString());
            assertNotNull(menu);
        }

        @Test
        public void pizza_test_fail(){
            Pizza menu = PizzaFactory.buildPizza("", "Thin crust with high quality flour and fresh tomato sauce and with creamy extra cheese.", Pizza.Size.MEDIUM, false, 65);
            System.out.println(menu.toString());
            assertNull(menu);
        }



        @Test
        public void pizza_timeoutFail_test() {
            assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
                Thread.sleep(2000);
            });
            String itemName = "Margherita pizza";
            String size = "Medium";
            boolean vegetarianOrNot = false;
            double price = 60;
            Pizza menu = PizzaFactory.buildPizza("Mushroom pizza", "Thick crust with high quality flour and fresh mushrooms and with double creamy extra cheese.", Pizza.Size.SMALL, false, 48);
            assertEquals(itemName, menu.getItemName());
            assertEquals(size, menu.getSize());
            assertEquals(vegetarianOrNot, menu.isVegetarianOrNot());
            assertEquals(price, menu.getPrice());
            System.out.println(menu.toString());
        }
        @Disabled("Disabled test")
        @Test
        public void pizza_disable_test(){
            Pizza menu = PizzaFactory.buildPizza("Vegetariana pizza", "Thin crust with high quality flour and fresh tomato sauce base and with high quality fresh vegetables.", Pizza.Size.EXTRA_SMALL, true, 32);
            System.out.println(menu.toString());
            assertNull(menu);

        }

        @Test
        public void pizza_equality_test(){
            Pizza menu = PizzaFactory.buildPizza("Margherita pizza", "Thin crust with high quality flour and fresh tomato sauce and with creamy extra cheese.", Pizza.Size.SMALL, false, 35);
            Pizza menu1 = PizzaFactory.buildPizza("Vegetariana pizza", "Thin crust with high quality flour and fresh tomato sauce base and with high quality fresh vegetables.", Pizza.Size.MEDIUM, true, 46);
            if(menu.equals(menu1)){
                System.out.println("Both objects are equal");//true

            }else
                System.out.println("Both objects are not equal");//false

        }

    }