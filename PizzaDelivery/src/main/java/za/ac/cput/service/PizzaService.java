package za.ac.cput.service;

import za.ac.cput.domain.Pizza;
import za.ac.cput.repository.PizzaRepository;

import java.util.Set;
/* PizzaService.java
 Author: Timothy Lombard (220154856)
 Date: 9th June (last updated) 2023
*/
public class PizzaService implements IPizzaService {

    private static PizzaService service = null;
    private static PizzaRepository repository = null;
    private PizzaService(){
        repository = PizzaRepository.getRepo();
    }

    public static PizzaService getService(){
        if(service == null){
            service = new PizzaService();
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
