package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Base;
import za.ac.cput.domain.Pizza;
import za.ac.cput.domain.Pizzeria;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


/* PizzaFactoryTest.java
 Author: Timothy Lombard (220154856)
 Date: 30th July (last updated) 2023
*/

    class PizzaFactoryTest {

        private static Base base = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THIN, Base.BaseTexture.CRISPY, 20);
        private static Pizzeria pizzeria = PizzeriaFactory.buildRestaurant("Hill Crest","Hotel Transalvania");


        @Test
        public void pizza_success_test(){
            Pizza menu = PizzaFactory.buildPizza(base, "Magherita pizza", "tomato sauce with fresh tomatoes, mozzarella cheese and basil which represent the colours of the Italian flag – white cheese, green basil and red tomato.", Pizza.Size.LARGE, false, 76, pizzeria);
            System.out.println(menu.toString());
            assertNotNull(menu);
        }

        @Test
        public void pizza_test_fail(){
            Pizza menu = PizzaFactory.buildPizza(base, "", "tomato sauce with fresh tomatoes, mozzarella cheese and basil which represent the colours of the Italian flag – white cheese, green basil and red tomato.", Pizza.Size.LARGE, false, 76, pizzeria);
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
            Pizza menu = PizzaFactory.buildPizza(base, "Magherita pizza", "tomato sauce with fresh tomatoes, mozzarella cheese and basil which represent the colours of the Italian flag – white cheese, green basil and red tomato.", Pizza.Size.LARGE, false, 76, pizzeria);
            assertEquals(itemName, menu.getName());
            assertEquals(size, menu.getSize());
            assertEquals(vegetarianOrNot, menu.isVegetarianOrNot());
            assertEquals(price, menu.getPrice());
            System.out.println(menu.toString());
        }
        @Disabled("Disabled test")
        @Test
        public void pizza_disable_test(){
            Pizza menu = PizzaFactory.buildPizza(base, "Magherita pizza", "tomato sauce with fresh tomatoes, mozzarella cheese and basil which represent the colours of the Italian flag – white cheese, green basil and red tomato.", Pizza.Size.LARGE, false, 76, pizzeria);
            System.out.println(menu.toString());
            assertNull(menu);

        }

        @Test
        public void pizza_equality_test(){
            Pizza menu = PizzaFactory.buildPizza(base, "Magherita pizza", "tomato sauce with fresh tomatoes, mozzarella cheese and basil which represent the colours of the Italian flag – white cheese, green basil and red tomato.", Pizza.Size.LARGE, false, 76, pizzeria);
            Pizza menu1 = PizzaFactory.buildPizza(base, "Magherita pizza", "tomato sauce with fresh tomatoes, mozzarella cheese and basil which represent the colours of the Italian flag – white cheese, green basil and red tomato.", Pizza.Size.MEDIUM, false, 60, pizzeria);
            if(menu.equals(menu1)){
                System.out.println("Both objects are equal");//true

            }else
                System.out.println("Both objects are not equal");//false

        }

    }