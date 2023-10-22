package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Topping;
import za.ac.cput.service.ToppingService;

import java.util.ArrayList;
/* ToppingController.java
 Author: Timothy Lombard (220154856)
 Date: 17th June (last updated) 2023
*/
//

@RestController
@RequestMapping("/topping")
public class ToppingController {

    @Autowired
    private ToppingService toppingService;

    @PostMapping("/create")
    public Topping create(@RequestBody Topping topping){
        return toppingService.create(topping);
    }

    @GetMapping("/read/{id}")
    public Topping read(@PathVariable Integer id){
        return toppingService.read(id);
    }

    @PostMapping("/update")
    public Topping update(@RequestBody Topping topping){
        return toppingService.update(topping);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return toppingService.delete(id);
    }

    @GetMapping({"/getall"})
    public ArrayList<Topping> getAll(){
        return toppingService.getAll();
    }



}

