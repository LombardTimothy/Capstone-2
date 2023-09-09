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
import za.ac.cput.domain.*;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CustomerAddressFactory;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerAddressControllerTest {

    private static Address address = AddressFactory.buildAddress("22", "Fall Street", "12", "East Bay", "Rock Bottom", "Ohio", "Crownlands", "0006", AddressType.FLAT_BUILDING);
    private static Customer customer = CustomerFactory.buildCustomer("Rickon", "Stark","076 675 8090", address);
    private static CustomerAddress customerAddress = CustomerAddressFactory.buildCustomerAddress(customer, address);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/customeraddress";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<CustomerAddress> postResponse = restTemplate.postForEntity(url, customerAddress, CustomerAddress.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        CustomerAddress createCustomerAddress = postResponse.getBody();
        System.out.println("Saved data: " + createCustomerAddress + "\n" + customerAddress);
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + customerAddress.getCustomerID().getCustomerID() + "/" + customerAddress.getAddressId().getAddressId();
        System.out.println("URL " + url);
        ResponseEntity<CustomerAddress> response = restTemplate.getForEntity(url, CustomerAddress.class);
        assertNotNull(customerAddress);
        System.out.println(response.getBody() + "\n" + customerAddress.toString());
    }

    @Test
    void c_getAll() {
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all: \n" + response + "\n" + response.getBody());
    }
}