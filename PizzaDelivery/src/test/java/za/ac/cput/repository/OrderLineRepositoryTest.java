package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/*
OrderLineRepositoryTest.java
Author: Tamryn Lisa Lewin (219211981)
Date: 06 April 2023
Last update: 08 April 2023
 */

@TestMethodOrder(MethodOrderer.MethodName.class)

class OrderLineRepositoryTest {
    private static OrderLineRepository orderLineRepository = OrderLineRepository.getRepository();

    private static LocalDate date1 = LocalDate.of(2023, 9, 17);
    private static LocalDate date2 = LocalDate.of(2023, 9, 20);
    private static LocalDate date3 = LocalDate.of(2023, 9, 23);

    private static Address address1 = AddressFactory.buildAddress("22", "Fall Street", "Rock Bottom", "0006", "Pennsylvania", "Westeros");
    private static Address address2 = AddressFactory.buildAddress("23", "Fall Street", "Rock Bottom", "0006", "Pennsylvania", "Westeros");
    private static Address address3 = AddressFactory.buildAddress("24A", "Fall Street", "Rock Bottom", "0006", "Pennsylvania", "Westeros");

    private static Customer customer1 = CustomerFactory.buildCustomer("Rickon", "Stark", address1);
    private static Customer customer2 = CustomerFactory.buildCustomer("Loras", "Tyrell", address2);
    private static Customer customer3 = CustomerFactory.buildCustomer("Theon", "Greyjoy", address3);

    private static Order order1 = OrderFactory.buildOrder(date1, customer1);
    private static Order order2 = OrderFactory.buildOrder(date2, customer2);
    private static Order order3 = OrderFactory.buildOrder(date3, customer3);

    private static Pizza pizza1 = PizzaFactory.buildPizza("Tikka chicken", "Thin crust, tikka and BBQ sauce, mozzarella cheese, mushroom, sweet bell pepper, spring onion, and chicken.", "Large", false, 156);
    private static Pizza pizza2 = PizzaFactory.buildPizza("Pepperoni", "Thick crust, tomato and BBQ sauce, mozzarella cheese, and pepperoni.", "Medium", false, 90);
    private static Pizza pizza3 = PizzaFactory.buildPizza("Creamy Veg", "Thin crust, cream cheese sauce, feta and mozzarella cheese, mushroom, sweet bell pepper, and onion.", "Large", true, 125);
    private static Pizza pizza4 = PizzaFactory.buildPizza("Beef", "Normal crust, mexican and BBQ sauce, extra mozzarella cheese, jalapeno, green pepper, onion, and ground beef.", "Small", false, 80);


    private static OrderLine orderLine1 = OrderLineFactory.buildOrderLine(1,order1, pizza1);
    private static OrderLine orderLine2 = OrderLineFactory.buildOrderLine(5, order2, pizza2);
    private static OrderLine orderLine3 = OrderLineFactory.buildOrderLine(10, order3, pizza3);

    @Test
    void a_orderLine_create() {
        OrderLine orderLineCreated1 = orderLineRepository.create(orderLine1);
        OrderLine orderLineCreated2 = orderLineRepository.create(orderLine2);
        OrderLine orderLineCreated3 = orderLineRepository.create(orderLine3);
        assertNotNull(orderLineCreated1);
        assertNotNull(orderLineCreated2);
        assertNotNull(orderLineCreated3);
        System.out.println("Created: \n" + orderLineCreated1 + "\n" + orderLineCreated2 + "\n" + orderLineCreated3);
    }

    @Test
    void b_orderLine_read() {
        OrderLine orderLineRead1 = orderLineRepository.read(orderLine1.getOrderLineId());
        OrderLine orderLineRead2 = orderLineRepository.read(orderLine2.getOrderLineId());
        OrderLine orderLineRead3 = orderLineRepository.read(orderLine3.getOrderLineId());
        assertNotNull(orderLineRead1);
        assertNotNull(orderLineRead2);
        assertNotNull(orderLineRead3);
        System.out.println("Read: \n" + orderLineRead1 + "\n" + orderLineRead2 + "\n" + orderLineRead3);
    }

    @Test
    void c_orderLine_update() {
        OrderLine orderLineUpdated1 = new OrderLine.Builder().copy(orderLine1).setQuantity(3).setPizza(pizza4).build();
        assertNotNull(orderLineRepository.update(orderLineUpdated1));
        System.out.println("Updated: \n" + orderLineUpdated1);
    }

    @Test
    void d_orderLine_delete() {
        System.out.println(orderLine1);
        boolean orderLineDeleted1 = orderLineRepository.delete(orderLine1.getOrderLineId());
        assertTrue(orderLineDeleted1);
        System.out.println(orderLineDeleted1);
    }

    @Test
    void e_orderLine_getAll() {
        System.out.println(orderLineRepository.getAll());
    }
}