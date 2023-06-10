package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.OrderLineService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderLineServiceImplTest {

    private static OrderLineServiceImpl service = null;

    private static LocalDate date = LocalDate.of(2023, 9, 17);
    private static Address address = AddressFactory.buildAddress("24A", "Fall Street", "Rock Bottom", "0006", "Pennsylvania", "Westeros");
    private static Customer customer = CustomerFactory.buildCustomer("Theon", "Greyjoy", address);
    private static Order order = OrderFactory.buildOrder(date, customer);
    private static Pizza pizza = PizzaFactory.buildPizza("Tikka chicken", "Thin crust, tikka and BBQ sauce, mozzarella cheese, mushroom, sweet bell pepper, spring onion, and chicken.", "Large", false, 156);
    private static OrderLine orderLine = OrderLineFactory.buildOrderLine(1,order, pizza);

    private OrderLineServiceImplTest() {
        service = OrderLineServiceImpl.getService();
    }

    @Test
    void a_create() {
        OrderLine createdOrderLine = service.create(orderLine);
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
        OrderLine updatedOrderLine = new OrderLine.Builder().copy(orderLine).setQuantity(5).build();
        assertNotNull(updatedOrderLine);
        System.out.println("\nUpdated: \n" + updatedOrderLine + "\n");
    }

    @Test
    void d_delete() {
        boolean deletedOrderLine = service.delete(orderLine.getOrderLineId());
        //assertTrue(deletedOrderLine);
        System.out.println(deletedOrderLine + "\n");
    }

    @Test
    void e_getAll() {
        System.out.println("All: \n" + service.getAll());
    }
}