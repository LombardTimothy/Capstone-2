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
import za.ac.cput.domain.Topping;
import za.ac.cput.factory.ToppingFactory;

import static org.junit.jupiter.api.Assertions.*;
/* ToppingControllerTest.java
 Author: Timothy Lombard (220154856)
 Date: 17th June (last updated) 2023
*/
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToppingControllerTest {

    private static Topping t = ToppingFactory.buildTopping("Pepperoni", "spicy salami made from cured pork and beef seasoned with paprika or other chili pepper", 20, 11);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/topping";

    @Test
    public void a_create(){
        String url = baseURL + "/create";
        ResponseEntity<Topping> postResponse = restTemplate.postForEntity(url ,t, Topping.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Topping createTopping = postResponse.getBody();
        System.out.println("Saved data: " + createTopping);
    }

    @Test
    public void b_read(){
        String url = baseURL + "/read/" + t.getToppingId();
        System.out.println("URL " + url);
        ResponseEntity<Topping> response = restTemplate.getForEntity(url, Topping.class);
        assertEquals(t.getToppingId(), response.getBody().getToppingId());
        System.out.println(response.getBody());
    }

    @Test
    public void c_update(){
        Topping updated = new Topping.Builder().copy(t).setToppingPrice(13).build();
        String url = baseURL + "/update";
        System.out.println("URL " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Topping> response = restTemplate.postForEntity(url, updated, Topping.class);
        assertNotNull(response.getBody());

    }


    @Test
    public void d_delete(){
        String url = baseURL + "/delete/" + t.getToppingId();
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