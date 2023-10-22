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

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/*
 PizzaToppingControllerTest.java
 Author: Timothy Lombard (220154856)
 Date: 25th July (last updated) 2023
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PizzaToppingControllerTest {
    private static Base base = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THIN, Base.BaseTexture.CRISPY, 20);
    private static Pizzeria pizzeria = PizzeriaFactory.buildPizzaria("Hill Crest","300 Long St, Cape Town City Centre, 8000");
    private static Pizza pizza = PizzaFactory.createPizza(base, "Margherita pizza", "Thin crust with high quality flour and fresh tomato sauce and with creamy extra cheese.", Pizza.Size.SMALL, false, 55, pizzeria);
    private static Topping topping = ToppingFactory.buildTopping("Bacon", "spicy bacon", 6, 15);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String pizzaURL = "http://localhost:8080/pizza";
    private final String toppingURL = "http://localhost:8080/topping";

    @Test
    public void a_create() {
        String urlPizza = pizzaURL + "/create";
        String urlTopping = toppingURL + "/create";

        ResponseEntity<Topping> postResponseTopping0 = restTemplate.postForEntity(urlTopping, topping, Topping.class);
        ResponseEntity<Pizza> postResponsePizza = restTemplate.postForEntity(urlPizza, pizza, Pizza.class);

        assertNotNull(postResponseTopping0);
        assertNotNull(postResponseTopping0.getBody());
        Topping createdTopping0 = postResponseTopping0.getBody();

        assertNotNull(postResponsePizza);
        assertNotNull(postResponsePizza.getBody());
        Pizza createPizza = postResponsePizza.getBody();

        Set<Topping> toppings = new HashSet<>();
        toppings.add(createdTopping0);
        createPizza.setToppings(toppings);

        assertNotNull(createPizza.getPizzaId());
        assertEquals(pizza.getName(), createPizza.getName());
        assertTrue(createPizza.getToppings().contains(createdTopping0));//this works

        createPizza.getToppings().forEach(System.out::println);
        System.out.println("Saved data: " + createPizza );
    }


    @Test
    public void b_read(){
        String urlPizza = pizzaURL + "/read/" + pizza.getPizzaId();
        String urlTopping = toppingURL + "/read/" + topping.getToppingId();
        System.out.println("URL " + urlPizza + "\n" + "URL " + urlTopping);

        ResponseEntity<Pizza> responsePizza = restTemplate.getForEntity(urlPizza, Pizza.class);
        ResponseEntity<Topping> responseTopping = restTemplate.getForEntity(urlTopping, Topping.class);
        assertEquals(pizza.getPizzaId(), responsePizza.getBody().getPizzaId());
        assertEquals(topping.getToppingId(), responseTopping.getBody().getToppingId());

        System.out.println(responsePizza.getBody() + "\n" + responseTopping.getBody());
    }

    @Test
    public void c_update(){
        Pizza updated = new Pizza.Builder().copy(pizza).setPrice(83).build();
        String urlPizza = pizzaURL + "/update";
        System.out.println("URL " + urlPizza);
        System.out.println("Post data: " + updated);

        ResponseEntity<Pizza> response = restTemplate.postForEntity(urlPizza, updated, Pizza.class);
        assertNotNull(response.getBody());
    }


    @Disabled
    @Test
    public void d_delete(){
        String urlTopping = toppingURL + "/delete/" + topping.getToppingId();
        System.out.println("URL " + urlTopping);
        restTemplate.delete(urlTopping);
    }

    @Test
    public void e_getAll(){
        String urlPizza = pizzaURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(urlPizza, HttpMethod.GET, entity, String.class);
        System.out.println("Show all ");
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void f_getAll(){
        String urlTopping = toppingURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(urlTopping, HttpMethod.GET, entity, String.class);
        System.out.println("Show all ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
