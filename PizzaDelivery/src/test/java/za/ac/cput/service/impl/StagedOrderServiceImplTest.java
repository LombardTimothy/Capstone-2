package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.StagedOrderService;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class StagedOrderServiceImplTest {
    @Autowired
    private StagedOrderServiceImpl service;

    private static Address address = AddressFactory.buildAddress("50", "Fall Street", "2", "East Bay", "Rock Bottom", "Ohio", "Crownlands", "0086", AddressType.FLAT_BUILDING);
    private static Customer customer = CustomerFactory.buildCustomer("Tim", "Tim", "095 402 1239", address);
    private static LocalDate date = LocalDate.of(2023, 7, 28);
    private static LocalDate date1 = LocalDate.of(2023, 7, 29);
    private static LocalTime time = LocalTime.now();
    private static Pizzeria pizzeria = PizzeriaFactory.buildPizzaria("Hill Crest","Hotel Transalvania");
    private static Base base = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THIN, Base.BaseTexture.CRISPY, 20);
    private static Pizza pizza = PizzaFactory.createPizza(base, "Magherita pizza", "tomato sauce with fresh tomatoes, mozzarella cheese and basil which represent the colours of the Italian flag – white cheese, green basil and red tomato.", Pizza.Size.LARGE, false, 76, pizzeria);
    private static StagedOrder stagedOrder = StagedOrderFactory.createOrder( date, time,  customer,"2",pizza,40, StagedOrder.OrderStatus.SHIPPED);

    @Test
    public void a_create(){
        System.out.println(stagedOrder);
        StagedOrder created = service.create(stagedOrder);
        System.out.println(created);
        assertNotNull(created);
    }

    @Test
    public void b_read(){
        StagedOrder reads = service.read(stagedOrder.getOrderId());
        System.out.println(reads);
        assertNotNull(reads);
    }

    @Test
    public void c_update(){
        StagedOrder updated = new StagedOrder.Builder()
                .copy(stagedOrder)
                .setCreateDate(date)
                .setCustomer(customer)
                .build();

        assertNotNull(service.update(updated));
        System.out.println(updated);
    }

    @Test
    public void d_delete(){
        boolean deleted = service.delete(stagedOrder.getOrderId());
        assertTrue(deleted);
        System.out.println(true + " = deleted");
    }

    @Test
    public void e_getAll(){
        System.out.println(service.getAll());
    }



}