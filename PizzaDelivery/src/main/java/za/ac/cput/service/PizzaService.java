package za.ac.cput.service;

import za.ac.cput.domain.Pizza;

import java.util.ArrayList;
import java.util.Set;
/* PizzaService.java
 Author: Timothy Lombard (220154856)
 Date: 4th August (last updated) 2023
*/

public interface PizzaService extends IService<Pizza, Integer>{

    Pizza create(Pizza pizza);

    Pizza read(Integer pizzaId);

    Pizza update(Pizza pizza);

    boolean delete(Integer pizzaId);

    public ArrayList<Pizza> getAll();

}
