package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Order;
import za.ac.cput.service.OrderService;

import java.util.ArrayList;
/* OrderController.java
 Author: Timothy Lombard (220154856)
 Date: 17th June (last updated) 2023
*/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Order create(@RequestBody Order order){
        return orderService.create(order);
    }

    @GetMapping("/read/{id}")
    public Order read(@PathVariable Integer id){
        return orderService.read(id);
    }

    @PostMapping("/update")
    public Order update(@RequestBody Order order){
        return orderService.update(order);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return orderService.delete(id);
    }

    @GetMapping({"/getall"})
    public ArrayList<Order> getAll(){
        return orderService.getAll();
    }
}
