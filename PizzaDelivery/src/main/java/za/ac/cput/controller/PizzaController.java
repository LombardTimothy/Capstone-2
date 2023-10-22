package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Pizza;
import za.ac.cput.domain.Topping;
import za.ac.cput.service.PizzaService;
import za.ac.cput.service.ToppingService;

import java.util.ArrayList;
import java.util.Set;
/* PizzaController.java
 Author: Timothy Lombard (220154856)
 Date: 4th August (last updated) 2023
*/
//

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping("/create")
    public Pizza create(@RequestBody Pizza pizza){
        return pizzaService.create(pizza);
    }

    @GetMapping("/read/{id}")
    public Pizza read(@PathVariable Integer id){
        return pizzaService.read(id);
    }

    @PostMapping("/update")
    public Pizza update(@RequestBody Pizza pizza){
        return pizzaService.update(pizza);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return pizzaService.delete(id);
    }

    @GetMapping({"/getall"})
    public ArrayList<Pizza> getAll(){
        return pizzaService.getAll();
    }
}
