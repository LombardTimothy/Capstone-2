package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Chef;
import za.ac.cput.factory.ChefFactory;
import za.ac.cput.service.ChefService;

import java.util.Set;

@RestController
@RequestMapping("/chef")
public class ChefController {
    @Autowired
    private ChefService chefService;

    @PostMapping("/create")
    public Chef create(@RequestBody Chef chef) {
        Chef chefCreated = ChefFactory.createChef("018", "Daniella", "Roxanna", "204", "Lebanon", "Sous chef");
        return chefService.create(chefCreated);
    }
    @GetMapping("/read/{id}")
    public Chef read(@PathVariable String id) {
        return chefService.read(id);
    }
    @PostMapping("/update")
    public Chef update(@RequestBody Chef chef) {
        return chefService.update(chef);
    }
    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id){
        return chefService.delete(id);
    }
    @RequestMapping({"/getall"})
    public Set<Chef> getall(){
        return chefService.getAll();
    }
}
