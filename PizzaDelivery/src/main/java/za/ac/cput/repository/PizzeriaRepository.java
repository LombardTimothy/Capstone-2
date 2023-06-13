package za.ac.cput.repository;

import java.util.HashSet;
import java.util.Set;

import za.ac.cput.domain.Pizzeria;

/*
   CustomerRepository.java
   Repository for the Customer class
   Author: Keenan Meyer (220194920)
   Date: 4th April 2023
*/
public class PizzeriaRepository implements IPizzeriaRepository {

    private static PizzeriaRepository repository = null;
    private Set<Pizzeria> pizzeriaList = null;

    private PizzeriaRepository()
    {
        pizzeriaList = new HashSet<Pizzeria>();
    }
    public static PizzeriaRepository getRepository(){
        if(repository == null)
            repository = new PizzeriaRepository();
        return repository;
    }
    @Override
    public Pizzeria create(Pizzeria pizzeria) {
        boolean success = pizzeriaList.add(pizzeria);
        if(!success)
            return null;
        return pizzeria;
    }

    @Override
    public Pizzeria read(String restaurantId) {
        for (Pizzeria e: pizzeriaList
        ) {
            if(e.getRestaurantID().equals(restaurantId))
                return e;


        } return null;
    }

    @Override
    public Pizzeria update(Pizzeria pizzeria) {
        Pizzeria buffer = read(pizzeria.getRestaurantID());
        if(buffer != null) {
            pizzeriaList.remove(buffer);
            pizzeriaList.add(pizzeria);
            return pizzeria;
        }
        return null;
    }

    @Override
    public boolean delete(String restaurantID) {
        Pizzeria pizzeria = read(restaurantID);
        if(pizzeria == null)
            return false;
        pizzeriaList.remove(pizzeria);
        return true;
    }
    @Override
    public Set<Pizzeria> getAll() {
        return pizzeriaList;
    }

}
