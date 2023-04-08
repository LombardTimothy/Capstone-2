package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;
import java.time.Duration;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/*
OrderLineFactoryTest.java
Author: Tamryn Lisa Lewin (219211981)
Date: 04 April 2023
Last update: 08 April 2023
 */

public class OrderLineFactoryTest {
    private static LocalDate date = LocalDate.of(2023, 9, 17);
    private static Address address = AddressFactory.buildAddress("22", "Fall Street", "Rock Bottom", "0006", "Pennsylvania", "Westeros");
    private static Customer customer = CustomerFactory.buildCustomer("Rickon", "Stark", address);
    private static Order order = OrderFactory.buildOrder(date, customer);
    private static Pizza pizza = PizzaFactory.buildPizza("Margherita pizza", "Thin crust with fresh tomato sauce and creamy extra cheese.", "Large", false, 65);

    @Test
    public void orderLine_test_pass() {
        OrderLine orderLine = OrderLineFactory.buildOrderLine(5, order, pizza);
        System.out.println(orderLine.toString());
        assertNotNull(orderLine);
    }

    @Test
    public void orderLine_test_fail() {
        OrderLine orderLine = OrderLineFactory.buildOrderLine(0, order, pizza);
        System.out.println(orderLine.toString());
        assertNull(orderLine);
    }

    @Test
    public void orderLine_test_equality_pass() {
        OrderLine orderLine = OrderLineFactory.buildOrderLine(10, order, pizza);
        OrderLine orderLine1 = OrderLineFactory.buildOrderLine(10, order, pizza);
        if(orderLine.equals(orderLine)) {
            System.out.println("Objects are equal.");
        } else
            System.out.println("Objects are not equal.");
    }

    @Test
    public void orderLine_test_equality_fail() {
        OrderLine orderLine = OrderLineFactory.buildOrderLine(10, order, pizza);
        OrderLine orderLine1 = OrderLineFactory.buildOrderLine(10, order, pizza);
        if(orderLine.equals(orderLine1)) {
            System.out.println("Objects are equal.");
        } else
            System.out.println("Objects are not equal.");
    }

    @Test
    public void orderLine_test_timeout_pass() {      //pass because test takes less than 2 seconds
        assertTimeoutPreemptively(Duration.ofMillis(2000), () -> {
            Thread.sleep(1000);
        });

        int quantity = 5;
        OrderLine orderLine = OrderLineFactory.buildOrderLine(5, order, pizza);
        assertEquals(quantity, orderLine.getQuantity());
        System.out.println(orderLine.toString());
    }

    @Test
    public void orderLine_test_timeout_fail() {         //fail because test takes longer than 1 second
        assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Thread.sleep(2000);
        });

        int quantity = 5;
        OrderLine orderLine = OrderLineFactory.buildOrderLine(5, order, pizza);
        assertEquals(quantity, orderLine.getQuantity());
        System.out.println(orderLine.toString());
    }

    @Disabled("Disabled test.")
    @Test
    public void orderLine_test_disabled() {
        OrderLine orderLine = OrderLineFactory.buildOrderLine(15, order, pizza);
        System.out.println(orderLine.toString());
        assertNotNull(orderLine);
    }
}
