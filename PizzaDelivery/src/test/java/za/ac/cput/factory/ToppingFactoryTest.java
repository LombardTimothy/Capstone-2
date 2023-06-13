package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Topping;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
/* ToppingFactoryTest.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
class ToppingFactoryTest {

     private static Topping t = ToppingFactory.buildTopping("Pepperoni", "spicy salami made from cured pork and beef seasoned with paprika or other chili pepper", 20, 11);
    private static Topping t1 = ToppingFactory.buildTopping("Pepperoni", "spicy salami made from cured pork and beef seasoned with paprika or other chili pepper", 10, 8);
    private static Topping t2 = ToppingFactory.buildTopping("", "spicy salami made from cured pork and beef seasoned with paprika or other chili pepper", 20, 11);

     @Test
    public void success(){
         System.out.println(t);
         assertNotNull(t);
     }

     @Test
    public void fail(){
         System.out.println(t2);
         assertNotNull(t2);
     }

    @Test
    public void timeoutFail_test() {
        assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Thread.sleep(2000);
        });
        String name = "Pepperoni";
        String description = "spicy salami";
        int quantity = 15;
        double price = 9;
        assertEquals(name, t.getToppingName());
        assertEquals(description, t.getToppingDescription());
        assertEquals(quantity, t.getToppingQuantity());
        assertEquals(price, t.getToppingPrice());
        System.out.println(t.toString());
    }

    @Disabled("Disabled test")
    @Test
    public void topping_disable_test(){
        System.out.println(t.toString());
        assertNull(t);

    }

    @Test
    public void topping_equality_test(){
        if(t.equals(t1)){
            System.out.println("Both objects are equal");//true

        }else
            System.out.println("Both objects are not equal");//false

    }


}