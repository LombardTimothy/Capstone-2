package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Driver;
import za.ac.cput.factory.DriverFactory;
import za.ac.cput.service.DriverService;

import java.util.Set;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;

    /*
    @PostMapping("/create")
    public Driver create(@RequestBody Driver driver){
       Driver driverCreated = DriverFactory.createDriver(driver.getDriverId().toString(),driver.getEmpId().toString(),driver.getDriverName().toString(), driver.getDriverSurname().toString());
       return driverService.create(driverCreated);

    }

     */

    @GetMapping("/read/{id}")
    public Driver read(@PathVariable String id){
        return driverService.read(id);
    }

    @PostMapping("/update")
    public Driver update(@RequestBody Driver driver){
        return driverService.update(driver);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return driverService.delete(id);
    }

    @RequestMapping({"/getall"})
    public Set<Driver> getAll(){
        return driverService.getAll();
    }

}


