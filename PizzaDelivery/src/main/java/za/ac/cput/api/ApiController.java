package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.*;
import za.ac.cput.service.*;
import java.util.ArrayList;
import java.util.Set;

/*
ApiController.java
Author: Timothy Lombard (220154856)
 Date: 1st September (last updated) 2023
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/api/ping")//connection
    public String ping() {
        System.out.println("Received ping request");
        return "pong";
    }
}
//