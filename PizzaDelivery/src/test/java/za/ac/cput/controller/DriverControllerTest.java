package za.ac.cput.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.*;
import za.ac.cput.factory.DriverFactory;
import za.ac.cput.factory.PizzeriaFactory;
import za.ac.cput.factory.VehicleFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DriverControllerTest {
    private static Vehicle vehicle = VehicleFactory.createVehicle("Krokie","MERC","C200","2011","purple");
    private static Pizzeria pizzeria = PizzeriaFactory.buildPizzaria("Zario","Kaapstad");
    private static Driver driver = DriverFactory.buildDriver("Azhar","Esau","0216552521","lyle@gmail.com",vehicle,pizzeria);
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

    }


    @Test
    void b_read() {
        String url = baseURL + "/read/" + driver.getEmpId();
        System.out.println("url: " + url);
        ResponseEntity<Driver> response = restTemplate.getForEntity(url, Driver.class);
        System.out.println("Response:" + response.getBody());
        assertNotNull(driver);
        System.out.println(response.getBody() + "\n" + driver.toString());

    }

    @Test
    void c_update() {
        Driver updated = (Driver) new Driver.Builder().copy(driver).setName("Lyle").build();

        String url = baseURL + "/update";
        System.out.println("url: " + url);
        System.out.println("Post data: " + updated);

        ResponseEntity<Driver>  response = restTemplate.postForEntity(url, updated, Driver.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void e_delete() {
        String url = baseURL + "/delete/" + driver.getEmpId();
        System.out.println("url: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getall";
        System.out.println("url: " + url);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println("Show ALL: ");
        System.out.println(response.getBody());
    }
}

