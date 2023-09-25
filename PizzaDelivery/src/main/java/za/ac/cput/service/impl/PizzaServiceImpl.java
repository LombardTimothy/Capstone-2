package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Pizza;
import za.ac.cput.repository.IPizzaRepository;
import za.ac.cput.service.PizzaService;

import java.util.ArrayList;
import java.util.Set;
/* PizzaServiceImpl.java
 Author: Timothy Lombard (220154856)
 Date: 4th August (last updated) 2023
*/
@Service
public class PizzaServiceImpl implements PizzaService {

    private IPizzaRepository pizzaRepo;

    @Autowired
    private PizzaServiceImpl(IPizzaRepository pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }


    @Override
    public Pizza create(Pizza pizza) {
        return this.pizzaRepo.save(pizza);
    }

    @Override
    public Pizza read(Integer id) {
        return this.pizzaRepo.findById(id).orElse(null);
    }

    @Override
    public Pizza update(Pizza pizza) {
        if (this.pizzaRepo.existsById(pizza.getPizzaId())) {
            return this.pizzaRepo.save(pizza);
        } else {
            return null;
        }

    }

    @Override
    public boolean delete(Integer id) {
        if (this.pizzaRepo.existsById(id)) {
            this.pizzaRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Pizza> getAll() {
        return (ArrayList<Pizza>) this.pizzaRepo.findAll();
    }

}
