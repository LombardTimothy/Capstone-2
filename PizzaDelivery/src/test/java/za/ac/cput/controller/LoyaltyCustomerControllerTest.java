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
import za.ac.cput.domain.LoyaltyCustomer;
import za.ac.cput.factory.LoyaltyCustomerFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
/*
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoyaltyCustomerControllerTest {

    private static LocalDate date = LocalDate.now();
    private static LoyaltyCustomer lc1 = LoyaltyCustomerFactory.createLoyaltyCustomer(date,35.34);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/loyaltycustomer";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<LoyaltyCustomer> postResponse = restTemplate.postForEntity(url, lc1, LoyaltyCustomer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        LoyaltyCustomer savedLoyaltyCustomer = postResponse.getBody();
        System.out.println("Saved data: \n" + savedLoyaltyCustomer);
        assertEquals(lc1.getLoyaltyCustomerId(), savedLoyaltyCustomer.getLoyaltyCustomerId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + lc1.getLoyaltyCustomerId();
        System.out.println("URL: " + url + "\n");
        ResponseEntity<LoyaltyCustomer> response = restTemplate.getForEntity(url, LoyaltyCustomer.class);
        assertEquals(lc1.getLoyaltyCustomerId(), response.getBody().getLoyaltyCustomerId());
        System.out.println("Read data: \n" + response.getBody());
    }

    @Test
    void c_update() {
        LoyaltyCustomer updatedLoyaltyCustomer = new LoyaltyCustomer.Builder().copy(lc1).setDiscounts(23.4).build();
        String url = baseURL + "/update/";
        System.out.println("URL: " + url + '\n');
        System.out.println("Post data: \n" + updatedLoyaltyCustomer);
        ResponseEntity<LoyaltyCustomer> response = restTemplate.postForEntity(url, updatedLoyaltyCustomer, LoyaltyCustomer.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete() {
        String url = baseURL + "/delete/" + lc1.getLoyaltyCustomerId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void e_getAll() {
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all: \n" + response + "\n" + response.getBody());

    }

}

 */
