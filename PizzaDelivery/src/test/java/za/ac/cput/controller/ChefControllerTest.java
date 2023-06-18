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
import za.ac.cput.domain.Chef;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.ChefFactory;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChefControllerTest {
    private static Chef chef = ChefFactory.createChef("044", "Nolongo", "Kaputsi", "223", "Congolese", "Head Chef");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/chef";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Chef> postResponse = restTemplate.postForEntity(url, chef, Chef.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.
                getBody());
        chef = postResponse.getBody();
        System.out.println("Saved data: " + chef);
        assertEquals(chef.getChefId(), postResponse.getBody().getChefId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + chef.getChefId();
        System.out.println("URL: " + url);
        ResponseEntity<Chef> response = restTemplate.getForEntity(url, Chef.class);
        assertEquals(chef.getChefId(), response.getBody().getChefId());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Chef updated = new Chef.Builder().copy(chef).setChefName("Nologono").build();
        String url = baseURL + "/update";
        System.out.println("URL : " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Chef> response = restTemplate.postForEntity(url, updated, Chef.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete() {
        String url = baseURL + "/delete/" + chef.getChefId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void getall() {
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}