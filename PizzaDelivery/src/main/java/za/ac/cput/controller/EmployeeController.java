package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.EmployeeService;

import java.util.Set;

/* EmployeeController.java
 Author: Dawood Kamalie (220147760)
 Date: 2nd August (last edited) 2023
*/
//

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }
    @GetMapping("/read/{id}")
    public Employee read(@PathVariable String id) {
        return employeeService.read(id);
    }
    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }
    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id){
        return employeeService.delete(id);
    }
    @RequestMapping({"/getall"})
    public Set<Employee> getall(){
        return employeeService.getAll();
    }
}
