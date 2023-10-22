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
import za.ac.cput.domain.Bill;
import za.ac.cput.factory.BillFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BillControllerTest {

    private static Bill bill1 = BillFactory.createBill(43.3);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/bill";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Bill> postResponse = restTemplate.postForEntity(url, bill1, Bill.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Bill savedBill = postResponse.getBody();
        System.out.println("Saved data: \n" + savedBill);
        assertEquals(bill1.getBillId(), savedBill.getBillId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + bill1.getBillId();
        System.out.println("URL: " + url + "\n");
        ResponseEntity<Bill> response = restTemplate.getForEntity(url, Bill.class);
        assertEquals(bill1.getBillId(), response.getBody().getBillId());
        System.out.println("Read data: \n" + response.getBody());
    }

    @Test
    void c_update() {
        Bill updatedBill = new Bill.Builder().copy(bill1).setTotalBill(60.45).build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url + '\n');
        System.out.println("Post data: \n" + updatedBill);
        ResponseEntity<Bill> response = restTemplate.postForEntity(url, updatedBill, Bill.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void d_delete() {
        String url = baseURL + "/delete/" + bill1.getBillId();
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