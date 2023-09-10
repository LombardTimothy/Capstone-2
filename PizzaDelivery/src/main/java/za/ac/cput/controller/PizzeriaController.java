package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Pizzeria;
import za.ac.cput.service.PizzeriaService;

import java.util.Set;

@RestController
@RequestMapping("/pizzeria")
public class PizzeriaController {
        @Autowired
        private PizzeriaService pizzeriaService;

        @PostMapping("/create")
        public Pizzeria create(@RequestBody Pizzeria pizzeria) {
            return pizzeriaService.create(pizzeria);
        }
        @GetMapping("/read/{id}")
        public Pizzeria read(@PathVariable String id) {
            return pizzeriaService.read(id);
        }

        @PostMapping("update")
        public Pizzeria update(@RequestBody Pizzeria pizzeria){
        return  pizzeriaService.update(pizzeria);
    }

        @GetMapping("/getAll")
        public Set<Pizzeria> getAll() {
            return pizzeriaService.getAll();
        }
}
