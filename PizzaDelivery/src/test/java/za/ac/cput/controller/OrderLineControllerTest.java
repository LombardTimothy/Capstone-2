package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

/*
OrderLineControllerTest.java
Author: Tamryn Lisa Lewin (219211981)
Date:  16 June 2023
Last update: 16 June 2023
*/


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderLineControllerTest {

    private static LocalDate date1 = LocalDate.of(2023, 10, 10);
    private static LocalTime time1 = LocalTime.now();
    private static Address address1 = AddressFactory.buildAddress("21", "Jump Street", "West Olmstead", "Bikini Bottom", "California", "Crownlands", "0007", AddressType.RESIDENTIAL_HOME);
    private static Customer customer1 = CustomerFactory.buildCustomer("Rickon", "Stark", "0868561233", address1);
    private static Pizzeria pizzeria = PizzeriaFactory.buildPizzaria("Hill Crest","Hotel Transalvania");
    private static Pizzeria pizzeria1 = PizzeriaFactory.buildPizzaria("Hill Crest","Hotel Transalvania");
    private static Order order1 = OrderFactory.createOrder(date1, time1, customer1, Order.OrderStatus.NEW, pizzeria);
    private static Base base = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THIN, Base.BaseTexture.CRISPY, 20);
    private static Pizza pizza = PizzaFactory.createPizza(base, "Margherita pizza", "Thin crust with high quality flour and fresh tomato sauce and with creamy extra cheese.", Pizza.Size.SMALL, false, 55, pizzeria1);
    private static Bill bill = BillFactory.createBill(75);

    private static OrderLine orderLine = OrderLineFactory.buildOrderLine(4, order1, pizza, bill);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/orderline";

    @Test
    @Transactional
    public void a_create() {

            String url = baseURL + "/create";
            ResponseEntity<OrderLine> postResponse = restTemplate.postForEntity(url, orderLine, OrderLine.class);
            assertNotNull(postResponse);
            assertNotNull(postResponse.getBody());

            OrderLine savedOrderLine = postResponse.getBody();
            System.out.println("Saved data: \n" + savedOrderLine);
         assertEquals(orderLine.getOrderLineId(), savedOrderLine.getOrderLineId());
    }

    @Test
    public void b_read() {
        String url = baseURL + "/read/" + orderLine.getOrderLineId();
        System.out.println("URL: " + url + "\n");
        ResponseEntity<OrderLine> response = restTemplate.getForEntity(url, OrderLine.class);
        assertEquals(orderLine.getOrderLineId(), response.getBody().getOrderLineId());
        System.out.println("Read data: \n" + response.getBody());
    }

    @Test
    public void c_update() {
        OrderLine updatedOrderLine = new OrderLine.Builder().copy(orderLine).setQuantity(10).build();
        String url = baseURL + "/update/";
        System.out.println("URL: " + url + '\n');
        System.out.println("Post data: \n" + updatedOrderLine);
        ResponseEntity<OrderLine> response = restTemplate.postForEntity(url, updatedOrderLine, OrderLine.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void d_delete() {
        String url = baseURL + "/delete/" + orderLine.getOrderLineId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    public void e_getAll() {
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all: \n" + response + "\n" + response.getBody());
    }
}

