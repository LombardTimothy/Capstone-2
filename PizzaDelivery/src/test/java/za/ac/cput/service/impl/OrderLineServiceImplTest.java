package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

/*
    OrderLineServiceImplTest.java
    Author: Tamryn Lisa Lewin (219211981)
    Date: 09 June 2023
    Last updated: 25 September 2023
*/

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class OrderLineServiceImplTest {

    @Autowired
    private OrderLineServiceImpl service;

    private static LocalDate date = LocalDate.of(2023, 9, 17);
    private static LocalTime time = LocalTime.now();
    private static Address address = AddressFactory.buildAddress("17", "Pisswater Bend", "13", "Flea Bottom", "King's Landing", "Crownlands", "Westeros", "5605", AddressType.FLAT_BUILDING);
    private static Customer customer = CustomerFactory.buildCustomer("Theon", "Greyjoy","078 675 7850", address);
    private static Pizzeria pizzeria = PizzeriaFactory.buildPizzaria("Hill Crest","Hotel Transalvania");
    private static Order order = OrderFactory.createOrder(date, time, customer, Order.OrderStatus.NEW, pizzeria);
    private static Base base = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THIN, Base.BaseTexture.CRISPY, 20);
    private static Pizza pizza = PizzaFactory.createPizza(base, "Margherita pizza", "Thin crust with high quality flour and fresh tomato sauce and with creamy extra cheese.", Pizza.Size.SMALL, false, 55, pizzeria);
    private static Bill bill = BillFactory.createBill(75);
    private static OrderLine orderLine = OrderLineFactory.buildOrderLine(1, order, pizza, bill);

    @Test
    public void a_create() {
        OrderLine createdOrderLine = service.create(orderLine);
        assertEquals(orderLine.getOrderLineId(), createdOrderLine.getOrderLineId());
        assertNotNull(createdOrderLine);
        System.out.println("Created: \n" + createdOrderLine + "\n");
    }

    @Test
    void b_read() {
        OrderLine readOrderLine = service.read(String.valueOf(orderLine.getOrderLineId()));
        assertNotNull(readOrderLine);
        System.out.printf("Read: \n" + readOrderLine + "\n");
    }

    @Test
    void c_update() {
        OrderLine newOrderLine = new OrderLine.Builder().copy(orderLine).setQuantity(5).build();
        OrderLine updatedOrderLine = service.update(newOrderLine);
        assertEquals(newOrderLine.getQuantity(), updatedOrderLine.getQuantity());
        assertNotNull(updatedOrderLine);
        System.out.println("\nUpdated: \n" + updatedOrderLine + "\n");
    }
    @Disabled
    @Test
    void d_delete() {
        boolean deletedOrderLine = service.delete(String.valueOf(orderLine.getOrderLineId()));
        assertTrue(deletedOrderLine);
        System.out.println("Deleted successfully: \n" + deletedOrderLine + "\n");
    }

    @Test
    void e_getAll() {
        System.out.println("All: \n" + service.getAll());
    }
}
