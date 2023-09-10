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
import za.ac.cput.domain.Base;
import za.ac.cput.factory.BaseFactory;

import static org.junit.jupiter.api.Assertions.*;
/* BaseControllerTest.java
 Author: Timothy Lombard (220154856)
 Date: 30th July (last updated) 2023
*/
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BaseControllerTest {

    private static Base b = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THICK, Base.BaseTexture.CRISPY, 26);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/base";

    @Test
    public void a_create(){
        String url = baseURL + "/create";
        ResponseEntity<Base> postResponse = restTemplate.postForEntity(url ,b, Base.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Base createBase = postResponse.getBody();
        System.out.println("Saved data: " + createBase);
    }

    @Test
    public void b_read(){
        String url = baseURL + "/read/" + b.getBaseId();
        System.out.println("URL " + url);
        ResponseEntity<Base> response = restTemplate.getForEntity(url, Base.class);
        assertEquals(b.getBaseId(), response.getBody().getBaseId());
        System.out.println(response.getBody());
    }

    @Test
    public void c_update(){
        Base updated = new Base.Builder().copy(b).setPrice(15).build();
        String url = baseURL + "/update";
        System.out.println("URL " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Base> response = restTemplate.postForEntity(url, updated, Base.class);
        assertNotNull(response.getBody());

    }


    @Test
    public void d_delete(){
        String url = baseURL + "/delete/" + b.getBaseId();
        System.out.println("URL " + url);
        restTemplate.delete(url);

    }

    @Test
    public void e_getAll(){
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all ");
        System.out.println(response);
        System.out.println(response.getBody());

    }


}