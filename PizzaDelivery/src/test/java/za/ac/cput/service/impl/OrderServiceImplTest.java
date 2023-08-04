package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AddressType;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.OrderFactory;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
/* OrderServiceImplTest.java
 Author: Timothy Lombard (220154856)
 Date: 4th August (last updated) 2023
 ////
*/
@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl service;

    private static Address address = AddressFactory.buildAddress("50", "Fall Street", "2", "East Bay", "Rock Bottom", "Ohio", "Crownlands", "0086", AddressType.FLAT_BUILDING);
    private static Customer customer = CustomerFactory.buildCustomer("Tim", "Tim", "095 402 1239", address);
    private static LocalDate date = LocalDate.of(2023, 7, 28);
    private static LocalDate date1 = LocalDate.of(2023, 7, 29);
    private static LocalTime time = LocalTime.now();
    private static Order order1 = OrderFactory.buildOrder(date1, time, customer, Order.OrderStatus.NEW);


    @Test
    public void a_create(){
        Order created = service.create(order1);
        System.out.println(created);
        assertNotNull(created);
    }

    @Test
    public void b_read(){
        Order reads = service.read(order1.getOrderId());
        System.out.println(reads);
        assertNotNull(reads);
    }

    @Test
    public void c_update(){
        Order updated = new Order.Builder().copy(order1).setCreateDate(date).setCustomer(customer).build();
        assertNotNull(service.update(updated));
        System.out.println(updated);
    }
    @Disabled
    @Test
    public void d_delete(){
        boolean deleted = service.delete(order1.getOrderId());
        assertTrue(deleted);
        System.out.println(true + " = deleted");
    }

    @Test
    public void e_getAll(){
        System.out.println(service.getAll());
    }

}