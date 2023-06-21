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
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.Topping;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.OrderFactory;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
/* OrderControllerTest.java
 Author: Timothy Lombard (220154856)
 Date: 17th June (last updated) 2023
*/
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {

private static Address address1 = AddressFactory.buildAddress("10B", "St Stones RD", "", "Southern suburb", "Cape Town", "Western Cape", "South Africa", "7945", Address.AddressType.RESIDENTIAL_HOME);

    private static Customer customer = CustomerFactory.buildCustomer("Thomas", "Lombardi","075 452 8339");

    private static LocalDate date = LocalDate.of(2023, 9, 17);
    private static LocalDate date1 = LocalDate.of(2023, 6, 25);

    private static LocalTime time = LocalTime.now();

    private static Order order = OrderFactory.buildOrder( date, time, customer);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/order";

    @Test
    public void a_create(){
        String url = baseURL + "/create";
        ResponseEntity<Order> postResponse = restTemplate.postForEntity(url ,order, Order.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Order createOrder = postResponse.getBody();
        System.out.println("Saved data: " + createOrder);
    }

    @Test
    public void b_read(){
        String url = baseURL + "/read/" + order.getOrderId();
        System.out.println("URL " + url);
        ResponseEntity<Order> response = restTemplate.getForEntity(url, Order.class);
        assertEquals(order.getOrderId(), response.getBody().getOrderId());
        System.out.println(response.getBody() );
    }

    @Test
    public void c_update(){
        Order updated = new Order.Builder().setOrderId(order.getOrderId()).setCreateDate(date1).setTime(time).setCustomer(order.getCustomer()).build();
        String url = baseURL + "/update";
        System.out.println("URL " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Order> response = restTemplate.postForEntity(url, updated, Order.class);
        assertNotNull(response.getBody());


    }


    @Test
    public void d_delete(){
        String url = baseURL + "/delete/" + order.getOrderId();
        System.out.println("URL " + url);
        restTemplate.delete(url);

    }

    @Test
    public void e_getAll(){
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all ");
        System.out.println(response);
        System.out.println(response.getBody());

    }


}