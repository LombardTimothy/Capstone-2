package za.ac.cput.service.impl;

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
 Date: 30th July (last updated) 2023
 ////
*/
@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl service;

    private static Address address = AddressFactory.buildAddress("30", "Church Street", "", "Southern", "Cape Town", "Western Cape", "South Afica", "0036", AddressType.RESIDENTIAL_HOME);
    private static Customer customer = CustomerFactory.buildCustomer("Sean", "Diaz", "095 091 5932", address);
    private static LocalDate date = LocalDate.of(2023, 7, 28);
    private static LocalDate date1 = LocalDate.of(2023, 7, 29);
    private static LocalDate date2 = LocalDate.of(2023, 7, 8);
    private static LocalTime time = LocalTime.now();
    private static Order order1 = OrderFactory.buildOrder(date1, time, customer, Order.OrderStatus.NEW);
    private static Order order2 = OrderFactory.buildOrder(date2, time, customer, Order.OrderStatus.NEW);

    @Test
    public void a_create(){
        Order created = service.create(order1);
        Order created1 = service.create(order2);
        System.out.println(created + "\n" + created1);
        assertNotNull(created);
        assertNotNull(created1);
    }

    @Test
    public void b_read(){
        Order reads = service.read(order1.getOrderId());
        Order reads1 = service.read(order2.getOrderId());
        System.out.println(reads + "\n" + reads1);
        assertNotNull(reads);
        assertNotNull(reads1);
    }

    @Test
    public void c_update(){
        Order updated = new Order.Builder().copy(order1).setCreateDate(date).setCustomer(customer).build();
        assertNotNull(service.update(updated));
        System.out.println(updated);
    }

    @Test
    public void d_delete(){
        boolean deleted = service.delete(order2.getOrderId());
        assertTrue(deleted);
        System.out.println(true + " = deleted");
    }

    @Test
    public void e_getAll(){
        System.out.println(service.getAll());
    }

}