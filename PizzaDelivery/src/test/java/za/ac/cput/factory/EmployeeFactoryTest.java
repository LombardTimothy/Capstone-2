package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

/*
 * EmployeeFactoryTest.java
 * Author: Dawood Kamalie  (220147760)
 * Date: 8/4/2023
 * */

class EmployeeFactoryTest {
    @Test
    void createEmployee() {
        Employee employee = EmployeeFactory.createEmployee( "Dawood", "Kamalie");
        System.out.println(employee);
        assertNotNull(employee);
    }
}