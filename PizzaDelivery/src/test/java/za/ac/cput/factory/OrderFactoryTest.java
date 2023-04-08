package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;

import java.time.Duration;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


/* OrderFactoryTest.java
 Author: Timothy Lombard (220154856)
 Date: 8th April (last updated) 2023
*/

    class OrderFactoryTest {

        private static Address address = AddressFactory.buildAddress("9", "11th Road, HealthField", "Cape Town", "7945", "Western Cape", "South Africa");
        private static Customer customer = CustomerFactory.buildCustomer("Thomas", "Lombardi", address);

        LocalDate date = LocalDate.of(2023, 9, 17);


        @Test
        public void order_test(){
            Order order = OrderFactory.buildOrder( date, customer);
            System.out.println(order.toString());
            assertNotNull(order);
        }

        @Test
        public void order_test_fail(){
            Order order = OrderFactory.buildOrder( date, customer);
            System.out.println(order.toString());
            //assertNotNull(order);
            assertEquals(3, order.getCreateDate());
        }

        @Test
        public void order_timeoutFail_test() {
            assertTimeoutPreemptively(Duration.ofMillis(2000), () -> {
                Thread.sleep(2100);
            });
            LocalDate date1 = LocalDate.of(2023, 5, 7);

            Order order = OrderFactory.buildOrder( date1, customer);
            assertEquals(date1, order.getCreateDate());
            System.out.println(order.toString());
        }
        @Disabled("Disabled test")
        @Test
        public void order_disable_test(){
            Order order = OrderFactory.buildOrder( date, customer);
            System.out.println(order.toString());
            assertNull(order);

        }

        @Test
        public void order_equality_test(){
            Order order = OrderFactory.buildOrder( date, customer);
            Order order1 = OrderFactory.buildOrder( date, customer);
            if(order.equals(order1)){
                System.out.println("Both objects are equal");//true

            }else
                System.out.println("Both objects are not equal");//false

        }
    }

