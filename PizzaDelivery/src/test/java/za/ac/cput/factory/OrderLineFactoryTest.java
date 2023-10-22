package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

/*
    OrderLineFactoryTest.java
    Author: Tamryn Lisa Lewin (219211981)
    Date: 04 April 2023
    Last update: 25 September 2023
 */

public class OrderLineFactoryTest {
    private static LocalDate date = LocalDate.of(2023, 9, 17);
    private static LocalTime time = LocalTime.now();
    private static Address address = AddressFactory.buildAddress("222", "Kingsroad", "6", "White Harbour", "Winterfell", "The North", "Westeros", "1010", AddressType.FLAT_BUILDING);
    private static Customer customer = CustomerFactory.buildCustomer("Rickon", "Stark","076 675 8090", address);
    private static Pizzeria pizzeria = PizzeriaFactory.buildPizzaria("Hill Crest","Hotel Transalvania");
    private static Order order = OrderFactory.createOrder(date,time, customer, Order.OrderStatus.DELIVERED, pizzeria);
    private static Base base = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THIN, Base.BaseTexture.CRISPY, 20);
    private static Pizza pizza = PizzaFactory.createPizza(base, "Margherita pizza", "Thin crust with high quality flour and fresh tomato sauce and with creamy extra cheese.", Pizza.Size.SMALL, false, 55, pizzeria);
    private static Bill bill = BillFactory.createBill(375);
    private static Bill bill1 = BillFactory.createBill(1125);


    @Test
    public void orderLine_test_pass() {
        OrderLine orderLine = OrderLineFactory.buildOrderLine(5, order, pizza, bill);
        System.out.println(orderLine.toString());
        assertNotNull(orderLine);
    }

    @Test
    public void orderLine_test_fail() {
        OrderLine orderLine = OrderLineFactory.buildOrderLine(0, order, pizza, bill1);
        System.out.println(orderLine.toString());
        assertNull(orderLine);
    }

    @Test
    public void orderLine_test_equality_pass() {
        OrderLine orderLine = OrderLineFactory.buildOrderLine(10, order, pizza, bill);
        OrderLine orderLine1 = OrderLineFactory.buildOrderLine(10, order, pizza, bill);
        if(orderLine.equals(orderLine)) {
            System.out.println("Objects are equal.");
        } else
            System.out.println("Objects are not equal.");
    }

    @Test
    public void orderLine_test_equality_fail() {
        OrderLine orderLine = OrderLineFactory.buildOrderLine(10, order, pizza, bill);
        OrderLine orderLine1 = OrderLineFactory.buildOrderLine(10, order, pizza, bill);
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
        OrderLine orderLine = OrderLineFactory.buildOrderLine(5, order, pizza, bill);
        assertEquals(quantity, orderLine.getQuantity());
        System.out.println(orderLine.toString());
    }

    @Test
    public void orderLine_test_timeout_fail() {         //fail because test takes longer than 1 second
        assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Thread.sleep(2000);
        });

        int quantity = 5;
        OrderLine orderLine = OrderLineFactory.buildOrderLine(5, order, pizza, bill);
        assertEquals(quantity, orderLine.getQuantity());
        System.out.println(orderLine.toString());
    }

    @Disabled("Disabled test.")
    @Test
    public void orderLine_test_disabled() {
        OrderLine orderLine = OrderLineFactory.buildOrderLine(15, order, pizza, bill1);
        System.out.println(orderLine.toString());
        assertNotNull(orderLine);
    }
}
