package za.ac.cput.repository;

import za.ac.cput.domain.Pizza;

import java.util.Set;

/* IPizzaRepository.java
 Author: Timothy Lombard (220154856)
 Date: 5th April (last updated) 2023
*/

public interface IPizzaRepository extends IRepository<Pizza, String>{
//Pizza replaces T and the String replaces ID from the IRepository interface
// it is extends because it from 1 interface to another

        Pizza create(Pizza pizza);

        Pizza read(String pizzaId);

        Pizza update(Pizza pizza);

        boolean delete(String pizzaId);

        public Set<Pizza> getAll();

    }


