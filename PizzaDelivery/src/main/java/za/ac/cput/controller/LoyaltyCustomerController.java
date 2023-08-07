package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.LoyaltyCustomer;
import za.ac.cput.service.LoyaltyCustomerService;

import java.util.Set;

/*
LoyaltyCustomerController.java
Author: Vuyisa Lutho Mqoboli (219191018)
Date: 01 August 2023
Last update: 08 August 2023
 */
@RestController
@RequestMapping("/loyaltycustomer")
public class LoyaltyCustomerController {

    @Autowired
    private LoyaltyCustomerService service;

    @PostMapping("/create")
    public LoyaltyCustomer create(@RequestBody LoyaltyCustomer loyaltyCustomer) {
        return service.create(loyaltyCustomer);
    }

    @GetMapping("/read/{loyaltyCustomerId}")
    public LoyaltyCustomer read(@PathVariable String loyaltyCustomerId) {
        return service.read(loyaltyCustomerId);
    }

    @PostMapping("/update")
    public LoyaltyCustomer update(@RequestBody LoyaltyCustomer loyaltyCustomer) {
        return service.update(loyaltyCustomer);
    }

    @DeleteMapping("/delete/{loyaltyCustomerId}")
    public boolean delete(@PathVariable String loyaltyCustomerId) {
        return service.delete(loyaltyCustomerId);
    }

    @GetMapping("/getall")
    public Set<LoyaltyCustomer> getAll() {
        return service.getAll();
    }
}
