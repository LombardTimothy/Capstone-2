package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Bill;
import za.ac.cput.service.BillService;
import java.util.Set;

/*
BillController.java
Author: Vuyisa Lutho Mqoboli (219191018)
Date: 01 August 2023
Last update: 08 August 2023
 */

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillService service;

    @PostMapping("/create")
    public Bill create(@RequestBody Bill bill) {
        return service.create(bill);
    }

    @GetMapping("/read/{billId}")
    public Bill read(@PathVariable String billId) {
        return service.read(billId);
    }

    @PostMapping("/update")
    public Bill update(@RequestBody Bill bill) {
        return service.update(bill);
    }

    @DeleteMapping("/delete/{billId}")
    public boolean delete(@PathVariable String billId) {
        return service.delete(billId);
    }

    @GetMapping("/getall")
    public Set<Bill> getAll() {
        return service.getAll();
    }
}
