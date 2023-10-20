package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/greetings")
public class aTestController {
    @GetMapping
    public ResponseEntity<String> sayGoodbye(){
        return ResponseEntity.ok("Safties Son OP");
    }
}
