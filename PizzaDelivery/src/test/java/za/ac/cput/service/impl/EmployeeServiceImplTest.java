package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Pizzeria;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.factory.PizzeriaFactory;

import static org.junit.jupiter.api.Assertions.*;
/* EmployeeServiceImplTest.java
 Author: Dawood Kamalie (220147760)
 Date: 11th June (last updated) 2023
*/


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class EmployeeServiceImplTest {
@Autowired
    private EmployeeServiceImpl service;
    private static Pizzeria pizzeria = PizzeriaFactory.buildRestaurant("Hill Crest","Hotel Transalvania");
    private static Employee employee1 = EmployeeFactory.createEmployee( "Jasmine", "DeToiit", "084-253-8832", "Jas@gmail.com", pizzeria);
    private static Employee employee2 = EmployeeFactory.createEmployee(  "David", "Camalito", "091-663-3621", "DCamalito@gmail.com", pizzeria);

    @Test
    public void a_create() {
        Employee created1 = service.create(employee1);
        Employee created2 =  service.create(employee2);
        System.out.println(created1 + "\n" + created2);
        assertNotNull(created1);
        assertNotNull(created2);
    }


    @Test
    public void b_read() {
    Employee read1 = service.read(employee1.getEmpId());
    Employee read2 = service.read(employee2.getEmpId());
    System.out.println(read1 + "\n" + read2);
    assertNotNull(read1);
    assertNotNull(read2);
    }

    @Test
    public void c_update() {
        Employee updated = new Employee.Builder().copy(employee2).setName("Generico").build();
        assertNotNull(service.update(updated));
        System.out.println(updated);
    }
@Disabled
    @Test
    public void d_delete() {
        boolean deleted = service.delete(employee1.getEmpId());
        assertTrue(deleted);
        System.out.println(true + " = deleted");
    }

    @Test
    public void getAll() {
        System.out.println(service.getAll());
    }
}

