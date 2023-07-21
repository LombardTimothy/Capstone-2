package za.ac.cput.service;

import za.ac.cput.domain.Pizza;

import java.util.ArrayList;
import java.util.Set;
/* PizzaService.java
 Author: Timothy Lombard (220154856)
 Date: 9th June (last updated) 2023
*/

public interface PizzaService extends IService<Pizza, String>{

    Pizza create(Pizza pizza);

    Pizza read(String pizzaId);

    Pizza update(Pizza pizza);

    boolean delete(String pizzaId);

    public Set<Pizza> getAll();

}
