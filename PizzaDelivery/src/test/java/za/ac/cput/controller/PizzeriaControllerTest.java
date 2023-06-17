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
import za.ac.cput.domain.Pizzeria;
import za.ac.cput.factory.PizzeriaFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PizzeriaControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/employee";
        private static Pizzeria pizzeria = PizzeriaFactory.buildRestaurant(
                "Grancho",
                25,
                true);

        private static Pizzeria pizzeria2 = PizzeriaFactory.buildRestaurant(
                "Grancho & Sons",
                22,
                true);
        @Test
        @Disabled
        void create() {
            String url = baseURL + "/create";
            ResponseEntity<Pizzeria> postResponse = restTemplate.postForEntity(url, pizzeria, Pizzeria.class);

            assertNotNull(postResponse);
            assertNotNull(postResponse.getBody());
            //assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
            Pizzeria savedEmployee = postResponse.getBody();

            System.out.println("Saved data: " + savedEmployee);
            assertEquals(pizzeria.getRestaurantID(), postResponse.getBody().getRestaurantID());
        }

        @Test
        @Disabled
        void read() {
            String url = baseURL + "/read/" + pizzeria.getRestaurantID();
            System.out.println("url: " + url);

            ResponseEntity<Pizzeria> response = restTemplate.getForEntity(url, Pizzeria.class);


            assertEquals(pizzeria.getRestaurantID(), response.getBody().getRestaurantID());
            System.out.println(response.getBody());
        }

        @Test
        void update() {
            Pizzeria updatedPizzeria = new Pizzeria
                    .Builder()
                    .copy(pizzeria)
                    .setIsOpen(false)
                    .build();

            String url = baseURL + "/update";
            System.out.println("url: " + url);
            System.out.println("Post data: " + updatedPizzeria);

            ResponseEntity<Pizzeria>  response = restTemplate.postForEntity(url, updatedPizzeria, Pizzeria.class);
            assertNotNull(response.getBody());
        }

        @Test
        void getAll() {
            String url = baseURL + "/getAll";
            System.out.println("url: " + url);

            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> entity = new HttpEntity<>(null, headers);
            ResponseEntity<String> reponse = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            System.out.println("Show ALL: ");
            System.out.println(reponse);
            System.out.println(reponse.getBody());
        }
    }
