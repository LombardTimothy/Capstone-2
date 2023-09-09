package za.ac.cput.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;;
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
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CustomerFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {
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


        @Autowired
        private TestRestTemplate restTemplate;
        private final String baseURL = "http://localhost:8080/customer";
        @Test
        void a_create() {
            String url = baseURL + "/create";
            ResponseEntity<Customer> postResponse = restTemplate.postForEntity(url, customer, Customer.class);

            assertNotNull(postResponse);
            assertNotNull(postResponse.getBody());
            //assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
            Customer savedEmployee = postResponse.getBody();

            System.out.println("Saved data: " + savedEmployee);
            assertEquals(customer.getCustomerID(), postResponse.getBody().getCustomerID());
        }

        @Test

        void b_read() {
            String url = baseURL + "/read/" + customer.getCustomerID();
            System.out.println("url: " + url);

            ResponseEntity<Customer> response = restTemplate.getForEntity(url, Customer.class);
            System.out.println("rest" +response);

            assertEquals(customer.getCustomerID(), response.getBody().getCustomerID());
            System.out.println("Specially read Cutomer:" + response.getBody());
        }

        @Test
        void c_update() {
            Customer updatedCustomer = new Customer
                    .Builder()
                    .copy(customer)
                    .setCustomerName("Spoilt")
                    .setCustomerSurname("Molly")
                    .setPhoneNumber("082 741 5565")
                    .setAddress(address)
                    .build();

            String url = baseURL + "/update";
            System.out.println("url: " + url);
            System.out.println("Post data: " + updatedCustomer);

            ResponseEntity<Customer>  response = restTemplate.postForEntity(url, updatedCustomer, Customer.class);
            assertNotNull(response.getBody());
        }



        @Test
        @Disabled
        void d_delete() {
            String url = baseURL + "/delete/" + customer.getCustomerID();
            System.out.println("url: " + url);
            restTemplate.delete(url);
        }

        @Test
        void e_getAll() {
            String url = baseURL + "/getAll";
            System.out.println("url: " + url);

            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> entity = new HttpEntity<>(null, headers);
            ResponseEntity<String> reponse = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            System.out.println("Show ALL: ");
            System.out.println(reponse);
            System.out.println(reponse.getBody());
        }

        /*

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/customer";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(url, customer, Customer.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        Customer savedEmployee = postResponse.getBody();

        System.out.println("Saved data: " + savedEmployee);
        assertEquals(customer.getCustomerID(), postResponse.getBody().getCustomerID());
    }

    @Test

    void b_read() {
        String url = baseURL + "/read/" + customer.getCustomerID();
        System.out.println("url: " + url);

        ResponseEntity<Customer> response = restTemplate.getForEntity(url, Customer.class);
        System.out.println("rest" +response);

        assertEquals(customer.getCustomerID(), response.getBody().getCustomerID());
        System.out.println("the bastard" + response.getBody());
    }

    @Test
    void c_update() {
        Customer updatedCustomer = new Customer
                .Builder()
                .copy(customer)
                .setCustomerName("Spoilt")
                .setCustomerSurname("Molly")
                .setPhoneNumber("082 741 5565")
                .setAddress(address)
                .build();

        String url = baseURL + "/update";
        System.out.println("url: " + url);
        System.out.println("Post data: " + updatedCustomer);

        ResponseEntity<Customer>  response = restTemplate.postForEntity(url, updatedCustomer, Customer.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void d_delete() {
        String url = baseURL + "/delete/" + customer.getCustomerID();
        System.out.println("url: " + url);
        restTemplate.delete(url);
    }

    @Test
    void e_getAll() {
        String url = baseURL + "/getAll";
        System.out.println("url: " + url);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println("Show ALL: ");
        System.out.println(response);
        System.out.println(response.getBody());

    }

         */
}
