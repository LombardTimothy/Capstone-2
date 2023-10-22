package za.ac.cput.factory;

import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Pizzeria;
import za.ac.cput.util.Helper;

/*
* EmployeeFactory.java
* Author: Dawood Kamalie  (220147760)
* Date: 7/4/2023
* */

public class EmployeeFactory {
    public static Employee buildEmployee(String name, String surname, String phoneNumber, String email, Pizzeria pizzeria) {
        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(surname) || Helper.isNullOrEmpty(phoneNumber) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(String.valueOf(pizzeria))) {
            return null;
        }

        Integer empId = Helper.generateId2();

       Employee employee = new Employee.Builder().setEmpId(empId).setName(name).setSurname(surname).setPhoneNumber(phoneNumber).setEmail(email).setPizzeria(pizzeria).build();
       return employee;
    }
}
