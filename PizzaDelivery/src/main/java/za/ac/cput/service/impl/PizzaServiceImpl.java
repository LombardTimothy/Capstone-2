package za.ac.cput.service.impl;

import za.ac.cput.domain.Pizza;
import za.ac.cput.repository.PizzaRepository;
import za.ac.cput.service.PizzaService;

import java.util.Set;
/* PizzaService.java
 Author: Timothy Lombard (220154856)
 Date: 9th June (last updated) 2023
*/
public class PizzaServiceImpl implements PizzaService {

    private static PizzaServiceImpl service = null;
    private static PizzaRepository repository = null;
    private PizzaServiceImpl(){
        repository = PizzaRepository.getRepo();
    }

    public static PizzaServiceImpl getService(){
        if(service == null){
            service = new PizzaServiceImpl();
        }
        return  service;
    }

    @Override
    public Pizza create(Pizza pizza) {
        Pizza created = repository.create(pizza);
        return created;
    }

    @Override
    public Pizza read(String pizzaId) {
        Pizza readPizza = repository.read(pizzaId);
        return readPizza;
    }

    @Override
    public Pizza update(Pizza pizza) {
        Pizza updated = repository.update(pizza);
        return updated;
    }

    @Override
    public boolean delete(String pizzaId) {
        boolean success = repository.delete(pizzaId);
        return success;
    }

    @Override
    public Set<Pizza> getAll() {
        return repository.getAll();
    }



}
