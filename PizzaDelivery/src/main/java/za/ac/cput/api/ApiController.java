package za.ac.cput.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
ApiController.java
Author: Timothy Lombard (220154856)
 Date: 1st September (last updated) 2023
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/api/ping")
    public String ping() {
        System.out.println("Received ping request");
        return "pong";
    }
}
