package za.ac.cput.service;

import za.ac.cput.domain.Topping;

import java.util.ArrayList;
/* ToppingService.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
public interface ToppingService extends IService<Topping, Integer> {

    Topping update(Topping topping);
    boolean delete(Integer toppingId);
    public ArrayList<Topping> getAll();
}
