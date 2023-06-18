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
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.factory.DriverFactory;
import za.ac.cput.factory.VehicleFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VehicleControllerTest {

    private static Vehicle vehicle = VehicleFactory.createVehicle("BMW");
    @Autowired
    private TestRestTemplate restTemplate;
    private  final String baseURL = "http://localhost:8080/vehicle";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Vehicle> postResponse = restTemplate.postForEntity(url,vehicle,Vehicle.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Vehicle saved = postResponse.getBody();
        System.out.println("Saved data: " + saved);
        assertEquals(saved.getVehicleId(),saved.getVehicleId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + vehicle.getVehicleId();
        System.out.println("url: " + url);

        ResponseEntity<Vehicle> response = restTemplate.getForEntity(url, Vehicle.class);
        System.out.println("read" +response);

        assertEquals(vehicle.getVehicleId(), response.getBody().getVehicleId());
        System.out.println("the driver" + response.getBody());
    }

    @Test
    void c_update() {
        Vehicle updated = new Vehicle.Builder().copy(vehicle).setVehicleId("1001").setVehicleType("VW").build();

        String url = baseURL + "/update";
        System.out.println("url: " + url);
        System.out.println("Post data: " + updated);

        ResponseEntity<Vehicle>  response = restTemplate.postForEntity(url, updated, Vehicle.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete() {
        String url = baseURL + "/delete/" + vehicle.getVehicleId();
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