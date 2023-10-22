package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Base;
import za.ac.cput.domain.Topping;
import za.ac.cput.service.BaseService;
import za.ac.cput.service.ToppingService;

import java.util.ArrayList;
/* BaseController.java
 Author: Timothy Lombard (220154856)
 Date: 17th June (last updated) 2023
*/
//
@RestController
@RequestMapping("/base")
public class BaseController {

    @Autowired
    private BaseService baseService;

    @PostMapping("/create")
    public Base create(@RequestBody Base base){
        return baseService.create(base);
    }

    @GetMapping("/read/{id}")
    public Base read(@PathVariable Integer id){
        return baseService.read(id);
    }

    @PostMapping("/update")
    public Base update(@RequestBody Base base){
        return baseService.update(base);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return baseService.delete(Integer.valueOf(id));
    }

    @GetMapping({"/getall"})
    public ArrayList<Base> getAll(){
        return baseService.getAll();
    }
}
