package za.ac.cput.service;

import za.ac.cput.domain.PizzaTopping;
import za.ac.cput.domain.PizzaToppingId;

import java.util.Set;
/* PizzaToppingService.java
 Author: Timothy Lombard (220154856)
 Date: 21st July (last updated) 2023
*/
public interface PizzaToppingService extends IService<PizzaTopping, PizzaToppingId> {

    PizzaTopping create(PizzaTopping pt);
    PizzaTopping read(PizzaToppingId ptId);
    boolean delete(PizzaToppingId ptId);

    public Set<PizzaTopping> getAll();
}
