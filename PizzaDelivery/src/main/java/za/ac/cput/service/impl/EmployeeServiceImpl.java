package za.ac.cput.service.impl;

import za.ac.cput.domain.Employee;
import za.ac.cput.repository.EmployeeRepository;
import za.ac.cput.service.EmployeeService;

import java.util.Set;

/* EmployeeServiceImpl.java
 Author: Dawood Kamalie (220147760)
 Date: 11th June (last updated) 2023
*/
public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeServiceImpl service = null;
    private static EmployeeRepository repository = null;
    private EmployeeServiceImpl() {
        repository = EmployeeRepository.getRepository();
    }

    public static EmployeeServiceImpl getService(){
        if(service == null) {
            service = new EmployeeServiceImpl();
        }
        return service;
    }

    @Override
    public Employee create(Employee employee) {
        Employee createdEmployee = repository.create(employee);
        return createdEmployee;
    }

    @Override
    public Employee read(String empId) {
        Employee readEmployee = repository.read(empId);
        return readEmployee;
    }

    @Override
    public Employee update(Employee employee) {
        Employee updatedEmployee = repository.update(employee);
        return updatedEmployee;
    }

    @Override
    public boolean delete(String empId) {
        boolean deletedEmployee = repository.delete(empId);
        return deletedEmployee;
    }

    @Override
    public Set<Employee> getAll() {
        return repository.getAll();
    }


}
