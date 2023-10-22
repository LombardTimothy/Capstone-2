package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;

import java.util.Set;

/* EmployeeService.java
 Author: Dawood Kamalie (220147760)
 Date: 11th June (last updated) 2023
*/

@Service
public interface EmployeeService extends IService<Employee, String>{
    Employee create(Employee employee);
    Employee read(String empId);
    Employee update(Employee employee);
    boolean delete(String empId);
    Set<Employee> getAll();
}
