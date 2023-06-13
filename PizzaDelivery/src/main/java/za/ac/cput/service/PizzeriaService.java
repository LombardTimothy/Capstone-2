package za.ac.cput.service;

import java.util.Set;

import za.ac.cput.domain.Pizzeria;

/*
 * PizzeriaService.java
 * interface for the Pizzeria Service
 * Author: Keenan Meyer - 220194920
 * Date: 09 June 2023
 */

public interface PizzeriaService extends IService<Pizzeria, String> {
    boolean delete(String restaurantNum);

    Set<Pizzeria> getAll();
}