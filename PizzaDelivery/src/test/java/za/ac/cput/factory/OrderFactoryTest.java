package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AddressType;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;


/* OrderFactoryTest.java
 Author: Timothy Lombard (220154856)
 Date: 8th April 2023
 Last update: 14 June 2023
*/

    class OrderFactoryTest {

        private static Address address = AddressFactory.buildAddress("21", "Jump Street", "", "West Olmstead", "Bikini Bottom", "California", "Crownlands", "0007", AddressType.RESIDENTIAL_HOME);

        private static Customer customer = CustomerFactory.buildCustomer("Thomas", "Lombardi","075 452 8339", address);

        private static LocalDate date = LocalDate.of(2023, 9, 17);

        private static LocalTime time = LocalTime.now();


        @Test
        public void order_test(){
            Order order = OrderFactory.buildOrder( date, time, customer);
            System.out.println(order.toString());
            assertNotNull(order);
        }

        @Test
        public void order_test_fail(){
            Order order = OrderFactory.buildOrder( date, time,  customer);
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

            Order order = OrderFactory.buildOrder( date1,time, customer);
            assertEquals(date1, order.getCreateDate());
            System.out.println(order.toString());
        }

        @Disabled("Disabled test")
        @Test
        public void order_disable_test(){
            Order order = OrderFactory.buildOrder( date, time, customer);
            System.out.println(order.toString());
            assertNull(order);

        }

        @Test
        public void order_equality_test(){
            Order order = OrderFactory.buildOrder( date, time, customer);
            Order order1 = OrderFactory.buildOrder( date,time, customer);
            if(order.equals(order1)){
                System.out.println("Both objects are equal");//true
            }else
                System.out.println("Both objects are not equal");//false
        }
    }

