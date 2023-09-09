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
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AddressType;
import za.ac.cput.factory.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;

/*
AddressControllerTest.java
Author: Tamryn Lisa Lewin (219211981)
Date:  13 June 2023
Last update: 19 August 2023
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressControllerTest {

    private static Address address = AddressFactory.buildAddress("124", "Conch Street", "Sandstone", "Sunnydale", "Sunspear", "Dorne", "0008", AddressType.RESIDENTIAL_HOME);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/address";

    @Test
    public void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Address> postResponse = restTemplate.postForEntity(url, address, Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Address savedAddress = postResponse.getBody();
        System.out.println("Saved data: \n" + savedAddress);
        assertEquals(address.getAddressId(), savedAddress.getAddressId());
    }

    @Test
    public void b_read() {
        String url = baseURL + "/read/" + address.getAddressId();
        System.out.println("URL: " + url + "\n");
        ResponseEntity<Address> response = restTemplate.getForEntity(url, Address.class);
        assertEquals(address.getAddressId(), response.getBody().getAddressId());
        System.out.println("Read data: \n" + response.getBody());
    }

    @Test
    public void c_update() {
        Address updatedAddress = new Address.Builder().copy(address).setStreetName("Sand Snake Street").build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url + "\n");
        System.out.println("Post data: \n" + updatedAddress);
        ResponseEntity<Address> response = restTemplate.postForEntity(url, updatedAddress, Address.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all: \n" + response + "\n" + response.getBody());
    }
}