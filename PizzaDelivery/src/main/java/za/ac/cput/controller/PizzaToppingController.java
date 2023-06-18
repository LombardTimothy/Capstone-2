package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.PizzaTopping;
import za.ac.cput.domain.Topping;
import za.ac.cput.service.PizzaToppingService;
import za.ac.cput.service.ToppingService;

import java.util.ArrayList;
import java.util.Set;
/* PizzaToppingController.java
 Author: Timothy Lombard (220154856)
 Date: 17th June (last updated) 2023
*/
@RestController
@RequestMapping("/pizzatopping")
public class PizzaToppingController {

    @Autowired
    private PizzaToppingService pizzaToppingService;

    @PostMapping("/create")
    public PizzaTopping create(@RequestBody PizzaTopping pizzaTopping){
        return pizzaToppingService.create(pizzaTopping);
    }

    @GetMapping("/read/{id}")
    public PizzaTopping read(@PathVariable String id){
        return pizzaToppingService.read(id, id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return pizzaToppingService.delete(id, id);
    }

    @GetMapping({"/getall"})
    public Set<PizzaTopping> getAll(){
        return pizzaToppingService.getAll();
    }
}
