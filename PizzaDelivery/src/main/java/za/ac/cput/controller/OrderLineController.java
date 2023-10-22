package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.OrderLine;
import za.ac.cput.service.OrderLineService;

import java.util.ArrayList;

/*
OrderLineController.java
Author: Tamryn Lisa Lewin (219211981)
Date: 13 June 2023
Last update: 16 June 2023
 */
//

@RestController
@RequestMapping("/orderline")
public class OrderLineController {

    @Autowired
    private OrderLineService service;

    @PostMapping("/create")
    public OrderLine create(@RequestBody OrderLine orderLine) {
        return service.create(orderLine);
    }

    @GetMapping("/read/{orderLineId}")
    public OrderLine read(@PathVariable String orderLineId) {
        return service.read(orderLineId);
    }

    @PostMapping("/update")
    public OrderLine update(@RequestBody OrderLine orderLine) {
        return service.update(orderLine);
    }

    @DeleteMapping("/delete/{orderLineId}")
    public boolean delete(@PathVariable String orderLineId) {
        return service.delete(orderLineId);
    }

    @GetMapping("/getall")
    public ArrayList<OrderLine> getAll() {
        return service.getAll();
    }

}
