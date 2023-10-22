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
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AddressType;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.LoyaltyCustomer;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.LoyaltyCustomerFactory;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoyaltyCustomerControllerTest {

    private static LocalDate date = LocalDate.now();

    private static Address address = AddressFactory.buildAddress("21",
            "Jump Street",
            "West Olmstead",
            "Bikini Bottom",
            "California",
            "Crownlands",
            "0007",
            AddressType.RESIDENTIAL_HOME);
    private static Customer customer = CustomerFactory.buildCustomer(
            "Keenan",
            "Meyer",
            "078 675 7850",
            address);

    private static LoyaltyCustomer lc1 = LoyaltyCustomerFactory.createLoyaltyCustomer(
            "Keenan",
            "Meyer",
            "0852849389",
            address,
            date,
            35.34,
            "12345678",
            "luto@gmail.com");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/loyaltycustomer";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<LoyaltyCustomer> postResponse = restTemplate.postForEntity(url, lc1, LoyaltyCustomer.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        Customer savedEmployee = postResponse.getBody();

        System.out.println("Saved data: " + savedEmployee);
        assertEquals(lc1.getCustomerID(), postResponse.getBody().getCustomerID());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + lc1.getCustomerID();
        System.out.println("url: " + url);

        ResponseEntity<LoyaltyCustomer> response = restTemplate.getForEntity(url, LoyaltyCustomer.class);
        System.out.println("rest" +response);

        assertEquals(lc1.getCustomerID(), response.getBody().getCustomerID());
        System.out.println("Specially read Loyalty Customer:" + response.getBody());
    }

    @Test
    void c_update() {
         LoyaltyCustomer updatedLoyaltyCustomer = (LoyaltyCustomer) new LoyaltyCustomer
                 .Builder()
                 .setPassword("12345677")
                 .copy(lc1)
                 .setCustomerName("Greg")
                 .build();

        String url = baseURL + "/update";
        System.out.println("url: " + url);
        System.out.println("Post data: " + updatedLoyaltyCustomer);

        ResponseEntity<LoyaltyCustomer>  response = restTemplate.postForEntity(url, updatedLoyaltyCustomer, LoyaltyCustomer.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void d_delete() {
        String url = baseURL + "/delete/" + lc1.getCustomerID();
        System.out.println("url: " + url);
        restTemplate.delete(url);
    }

    @Test
    void e_getAll() {
        String url = baseURL + "/getall";
        System.out.println("url: " + url);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> reponse = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println("Show ALL: ");
        System.out.println(reponse);
        System.out.println(reponse.getBody());
    }
}
