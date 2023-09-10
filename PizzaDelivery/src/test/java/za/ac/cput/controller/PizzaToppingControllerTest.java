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

import static org.junit.jupiter.api.Assertions.*;

/* PizzaToppingControllerTest.java
 Author: Timothy Lombard (220154856)
 Date: 25th July (last updated) 2023
*/

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PizzaToppingControllerTest {


    private static Base base = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THIN, Base.BaseTexture.CRISPY, 20);
    private static Pizzeria pizzeria = PizzeriaFactory.buildPizzaria("Hill Crest","Hotel Transalvania");
    private static Pizza pizza = PizzaFactory.createPizza(base, "Margherita pizza", "Thin crust with high quality flour and fresh tomato sauce and with creamy extra cheese.", Pizza.Size.SMALL, false, 55, pizzeria);
    private static Topping topping = ToppingFactory.buildTopping("Bacon", "spicy bacon", 6, 15);


    private static PizzaTopping pt = PizzaToppingFactory.buildPizzaTopping(pizza, topping);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String pizzaToppingURL = "http://localhost:8080/pizzatopping";

    @Test
    public void a_create(){
        String url = pizzaToppingURL + "/create";
        ResponseEntity<PizzaTopping> postResponse = restTemplate.postForEntity(url ,pt, PizzaTopping.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        PizzaTopping createPizzaTopping = postResponse.getBody();
        System.out.println("Saved data: " + createPizzaTopping + "\n" + pt);
    }

    @Test
    public void b_read(){
        String url = pizzaToppingURL + "/read/" + pt.getPizza().getPizzaId() + "/" + pt.getTopping().getToppingId();

        System.out.println("URL " + url);
        ResponseEntity<PizzaTopping> response = restTemplate.getForEntity(url, PizzaTopping.class);
        assertNotNull(pt);
        System.out.println(response.getBody() + "\n" + pt.toString());
    }

    @Disabled
    @Test
    public void d_delete(){
    String url = pizzaToppingURL + "/read/" + pt.getPizza().getPizzaId() + "/" + pt.getTopping().getToppingId();
        System.out.println("URL " + url);
        restTemplate.delete(url);
    }

    @Test
    public void e_getAll(){
        String url = pizzaToppingURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all ");
        System.out.println(response);
        System.out.println(response.getBody());
    }

}