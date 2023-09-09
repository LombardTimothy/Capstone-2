package za.ac.cput.service;

import java.util.Set;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Pizzeria;

/*
 * PizzeriaService.java
 * interface for the Pizzeria Service
 * Author: Keenan Meyer - 220194920
 * Date: 09 June 2023
 */

public interface PizzeriaService extends IService<Pizzeria, String> {
    Pizzeria create(Pizzeria pizzeria);
    Pizzeria read(String pizzeriaId);
    Pizzeria update(Pizzeria pizzeria);
    Set<Pizzeria> getAll();
}