package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Employee;

import java.util.Set;

/*
 * IEmployeeRepository.java
 * Author: Dawood Kamalie  (220147760)
 * Date: 8/4/2023
 * */

public interface IEmployeeRepository extends JpaRepository<Employee, String> {
     Set<Employee> getAll();
}
