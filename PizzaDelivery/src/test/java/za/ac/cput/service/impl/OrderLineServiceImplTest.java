package za.ac.cput.service.impl;

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
Last updated: 14 June 2023
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class OrderLineServiceImplTest {

    @Autowired
    private OrderLineServiceImpl service;

    private static LocalDate date = LocalDate.of(2023, 9, 17);
    private static LocalTime time = LocalTime.now();
    private static Address address = AddressFactory.buildAddress("22", "Fall Street", "13", "East Bay", "Rock Bottom", "Ohio", "King's Landing", "0006", AddressType.FLAT_BUILDING);
    private static Customer customer = CustomerFactory.buildCustomer("Theon", "Greyjoy","078 675 7850");
    private static Order order = OrderFactory.buildOrder(date, time, customer, Order.OrderStatus.NEW);//you can change the order status if you want, to whatever
    private static Base base = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THIN, Base.BaseTexture.CRISPY, 20);
    private static Pizza pizza = PizzaFactory.buildPizza(base, "Margherita pizza", "Thin crust with high quality flour and fresh tomato sauce and with creamy extra cheese.", Pizza.Size.SMALL, false, 55);
    private static OrderLine orderLine = OrderLineFactory.buildOrderLine(1,order, pizza);

    @Test
    public void a_create() {
        OrderLine createdOrderLine = service.create(orderLine);
        assertEquals(orderLine.getOrderLineId(), createdOrderLine.getOrderLineId());
        assertNotNull(createdOrderLine);
        System.out.println("Created: \n" + createdOrderLine + "\n");
    }

    @Test
    void b_read() {
        OrderLine readOrderLine = service.read(orderLine.getOrderLineId());
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

    @Test
    void d_delete() {
        boolean deletedOrderLine = service.delete(orderLine.getOrderLineId());
        assertTrue(deletedOrderLine);
        System.out.println("Deleted successfully: \n" + deletedOrderLine + "\n");
    }

    @Test
    void e_getAll() {
        System.out.println("All: \n" + service.getAll());
    }
}