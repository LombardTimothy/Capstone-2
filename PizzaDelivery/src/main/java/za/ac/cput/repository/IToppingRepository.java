package za.ac.cput.repository;

import za.ac.cput.domain.Topping;

import java.util.ArrayList;
/* IToppingRepository.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
public interface IToppingRepository extends IRepository<Topping, String> {

    public ArrayList<Topping> getAll();
}
