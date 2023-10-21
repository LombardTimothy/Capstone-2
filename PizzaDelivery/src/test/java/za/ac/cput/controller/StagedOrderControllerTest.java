package za.ac.cput.controller;

import org.junit.jupiter.api.Disabled;
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
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StagedOrderControllerTest {
    private static Address address = AddressFactory.buildAddress("21", "1st Street", "Southern", "Cape Town", "Western Cape", "South Africa", "0986", AddressType.RESIDENTIAL_HOME);

    private static Customer customer = CustomerFactory.buildCustomer("Daniel", "Diaz","085 451 7339", address);

    private static LocalDate date = LocalDate.of(2023, 9, 17);
    private static LocalDate date1 = LocalDate.of(2023, 6, 25);

    private static LocalTime time = LocalTime.now();
    private static Pizzeria pizzeria = PizzeriaFactory.buildPizzaria("Hill Crest","Hotel Transalvania");

    //private static Order order = OrderFactory.createOrder(date, time, customer, Order.OrderStatus.NEW, pizzeria);

    private static Base base = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THIN, Base.BaseTexture.CRISPY, 20);
    private static Pizza pizza = PizzaFactory.createPizza(base, "Magherita pizza", "tomato sauce with fresh tomatoes, mozzarella cheese and basil which represent the colours of the Italian flag – white cheese, green basil and red tomato.", Pizza.Size.LARGE, false, 76, pizzeria);
    private static StagedOrder order = StagedOrderFactory.createOrder( date, time,  customer,"2",pizza,40, StagedOrder.OrderStatus.SHIPPED);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/stagedOrder";

    @Test
    public void a_create(){
        String url = baseURL + "/create";
        ResponseEntity<StagedOrder> postResponse = restTemplate.postForEntity(url ,order, StagedOrder.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        StagedOrder createOrder = postResponse.getBody();
        System.out.println("Saved data: " + createOrder);
    }

    @Test
    public void b_read(){
        String url = baseURL + "/read/" + order.getOrderId();
        System.out.println("URL " + url);
        ResponseEntity<StagedOrder> response = restTemplate.getForEntity(url, StagedOrder.class);
        assertEquals(order.getOrderId(), response.getBody().getOrderId());
        System.out.println(response.getBody() );
    }

    @Test
    public void c_update(){
        StagedOrder updated = new StagedOrder.Builder().setOrderId(order.getOrderId()).setCreateDate(date1).setTime(time).setCustomer(order.getCustomer()).build();
        String url = baseURL + "/update";
        System.out.println("URL " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<StagedOrder> response = restTemplate.postForEntity(url, updated, StagedOrder.class);
        assertNotNull(response.getBody());
    }


    @Test
    @Disabled
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