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
import za.ac.cput.domain.Pizza;
import za.ac.cput.domain.PizzaTopping;
import za.ac.cput.domain.Topping;
import za.ac.cput.factory.BaseFactory;
import za.ac.cput.factory.PizzaFactory;
import za.ac.cput.factory.PizzaToppingFactory;
import za.ac.cput.factory.ToppingFactory;

import static org.junit.jupiter.api.Assertions.*;

/* PizzaToppingControllerTest.java
 Author: Timothy Lombard (220154856)
 Date: 25th July (last updated) 2023
*/

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PizzaToppingControllerTest {

    //I must still figure out how to fix this.


    //I just made changes in here to get rid of the errors(its probably wrong, lol).. you can obvs make your proper changes now
    private static Base base = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THIN, Base.BaseTexture.CRISPY, 20);
    private static Pizza pizza = PizzaFactory.buildPizza(base, "Margherita pizza", "Thin crust with high quality flour and fresh tomato sauce and with creamy extra cheese.", Pizza.Size.SMALL, false, 55);
    private static Topping topping = ToppingFactory.buildTopping("Bacon", "spicy bacon", 6, 15);


    private static PizzaTopping pt = PizzaToppingFactory.buildPizzaTopping(pizza, topping);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/pizzatopping";

    @Test
    public void a_create(){
        String url = baseURL + "/create";
        ResponseEntity<PizzaTopping> postResponse = restTemplate.postForEntity(url ,pt, PizzaTopping.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        PizzaTopping createPizzaTopping = postResponse.getBody();
        System.out.println("Saved data: " + createPizzaTopping);
    }

    @Test
    public void b_read(){//needs checking
//        String url = baseURL + "/read/" + pt.getPizzaId() + pt.getToppingId();
        String url = baseURL + "/read/" + pt.getPizza() + pt.getTopping();

        System.out.println("URL " + url);
        ResponseEntity<PizzaTopping> response = restTemplate.getForEntity(url, PizzaTopping.class);
        assertNotNull(pt);
        System.out.println(response.getBody() + pt.toString());
    }

//@Disabled
    @Test
    public void d_delete(){
//        String url = baseURL + "/delete/" + pt.getPizzaId() + pt.getToppingId();
        String url = baseURL + "/delete/" + pt.getPizza() + pt.getTopping();
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