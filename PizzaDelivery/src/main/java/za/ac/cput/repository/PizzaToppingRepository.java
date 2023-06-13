package za.ac.cput.repository;

import za.ac.cput.domain.Pizza;
import za.ac.cput.domain.PizzaTopping;
import za.ac.cput.domain.PizzaTopping;

import java.util.HashSet;
import java.util.Set;
/* PizzaToppingRepository.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
public class PizzaToppingRepository implements IPizzaToppingRepository{

    private static za.ac.cput.repository.PizzaToppingRepository repo = null;
    private Set<PizzaTopping> pizzaToppingDB;
    private PizzaToppingRepository(){
        pizzaToppingDB = new HashSet<PizzaTopping>();
    }

    public static za.ac.cput.repository.PizzaToppingRepository getRepo(){//singleton, having access to the private constructor
        if(repo == null){
            repo = new za.ac.cput.repository.PizzaToppingRepository();
        }
        return repo;
    }

    @Override
    public PizzaTopping create(PizzaTopping pizzaTopping) {
        boolean success = pizzaToppingDB.add(pizzaTopping);
        if(!success) {
            return null;
        }else {
            return pizzaTopping;
        }
    }

    @Override
    public PizzaTopping read(String s) {
        return null;
    }



    @Override
    public PizzaTopping read(String pizzaId, String toppingId) {
        for(PizzaTopping p : pizzaToppingDB){
            if(p.getPizzaId().equals(pizzaId) && p.getToppingId().equals(toppingId) )
                return p;
        }
        return null;

    }

@Override
public PizzaTopping update(PizzaTopping pizzaTopping){
    PizzaTopping oldPizza = read(pizzaTopping.getPizzaId(), pizzaTopping.getToppingId());
    if(oldPizza != null){
        pizzaToppingDB.remove(oldPizza);
        pizzaToppingDB.add(pizzaTopping);
        return pizzaTopping;
    }
    return null;
}
    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public boolean delete(String pizzaId, String toppingId) {
        PizzaTopping deletePizza = read(pizzaId, toppingId);
        if(deletePizza != null){
            pizzaToppingDB.remove(deletePizza);
            System.out.println("Could delete");
            return true;
        }else {
            System.out.println("Could not delete");
            return false;
        }
    }

    @Override
    public Set<PizzaTopping> getAll(){return pizzaToppingDB;}

}
