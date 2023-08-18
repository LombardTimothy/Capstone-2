package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.factory.VehicleFactory;
import za.ac.cput.service.VehicleService;

import java.util.Set;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
/*
    @PostMapping("/create")
    public Vehicle create(@RequestBody Vehicle vehicle){
       Vehicle vehicleCreated = VehicleFactory.createVehicle("VW");
        return vehicleService.create(vehicleCreated);
    }

 */

    @GetMapping("/read/{id}")
    public Vehicle read(@PathVariable String id){
        return vehicleService.read(id);
    }

    @PostMapping("/update")
    public Vehicle update(@RequestBody Vehicle vehicle){
        return vehicleService.update(vehicle);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return vehicleService.delete(id);
    }

    @RequestMapping({"/getall"})
    public Set<Vehicle> getAll(){
        return vehicleService.getAll();
    }
}


