package za.ac.cput.service.impl;

import za.ac.cput.domain.PizzaTopping;
import za.ac.cput.repository.PizzaToppingRepository;
import za.ac.cput.repository.ToppingRepository;
import za.ac.cput.service.PizzaToppingService;

import java.util.ArrayList;
import java.util.Set;
/* PizzaToppingServiceImpl.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
public class PizzaToppingServiceImpl implements PizzaToppingService {

    private static PizzaToppingServiceImpl pizzaToppingService = null;
    private static PizzaToppingRepository pizzaToppingRepo = null;
    private PizzaToppingServiceImpl(){
        pizzaToppingRepo = PizzaToppingRepository.getRepo();
    }

    public static PizzaToppingServiceImpl getPizzaToppingService(){//singleton, having access to the private constructor
        if(pizzaToppingService == null){
            pizzaToppingService = new PizzaToppingServiceImpl();
        }
        return pizzaToppingService;
    }

    @Override
    public PizzaTopping create(PizzaTopping pizzaTopping) {
        PizzaTopping created = pizzaToppingRepo.create(pizzaTopping);
        return created;
    }

    @Override
    public PizzaTopping read(String s) {
        return null;
    }

    @Override
    public PizzaTopping read(String pizzaId, String toppingId) {
        PizzaTopping readPizzaTopping = pizzaToppingRepo.read(pizzaId, toppingId);
        return readPizzaTopping;
    }


    @Override
    public boolean delete(String pizzaId, String toppingId) {
        boolean success = pizzaToppingRepo.delete(pizzaId, toppingId);
        return success;
    }

    @Override
    public Set<PizzaTopping> getAll(){return pizzaToppingRepo.getAll();}
}
