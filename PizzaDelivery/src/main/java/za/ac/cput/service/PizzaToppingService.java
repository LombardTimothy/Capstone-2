package za.ac.cput.service;

import za.ac.cput.domain.PizzaTopping;

import java.util.Set;
/* PizzaToppingService.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
public interface PizzaToppingService extends IService<PizzaTopping, String> {

    PizzaTopping read(String pizzaId, String toppingId);
    boolean delete(String pizzaId, String toppingId);
    public Set<PizzaTopping> getAll();
}
