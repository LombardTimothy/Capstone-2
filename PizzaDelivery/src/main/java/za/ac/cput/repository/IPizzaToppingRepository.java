package za.ac.cput.repository;

import za.ac.cput.domain.PizzaTopping;

import java.util.Set;
/* IPizzaToppingRepository.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
public interface IPizzaToppingRepository extends IRepository<PizzaTopping, String> {


    PizzaTopping read(String pizzaId, String toppingId);
    boolean delete(String pizzaId, String toppingId);
    public Set<PizzaTopping> getAll();
}
