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
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Driver;
import za.ac.cput.factory.DriverFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DriverControllerTest {
    private static Driver driver = DriverFactory.createDriver("201","101","Zar","Mancini");
    @Autowired
    private TestRestTemplate restTemplate;
    private  final String baseURL = "http://localhost:8080/driver";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Driver> postResponse = restTemplate.postForEntity(url,driver,Driver.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Driver saved = postResponse.getBody();
        System.out.println("Saved data: " + saved);
        assertEquals(saved.getDriverId(),saved.getDriverId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + driver.getDriverId();
        System.out.println("url: " + url);

        ResponseEntity<Driver> response = restTemplate.getForEntity(url, Driver.class);
        System.out.println("read" +response);

        assertEquals(driver.getDriverId(), response.getBody().getDriverId());
        System.out.println("the driver" + response.getBody());
    }

    @Test
    void c_update() {
        Driver updated = new Driver.Builder().copy(driver).setDriverId("5005").setDriverName("Lyle").setDriverSurname("Peters").build();

        String url = baseURL + "/update";
        System.out.println("url: " + url);
        System.out.println("Post data: " + updated);

        ResponseEntity<Driver>  response = restTemplate.postForEntity(url, updated, Driver.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete() {
        String url = baseURL + "/delete/" + driver.getDriverId();
        System.out.println("url: " + url);
        restTemplate.delete(url);
    }

    @Test
    void e_getAll() {
        String url = baseURL + "/getall";
        System.out.println("url: " + url);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println("Show ALL: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}