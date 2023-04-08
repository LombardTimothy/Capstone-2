package za.ac.cput.repository;

import za.ac.cput.domain.Pizza;

import java.util.HashSet;
import java.util.Set;

/* PizzaRepository.java
 Author: Timothy Lombard (220154856)
 Date: 5th April (last updated) 2023
*/

    public  class PizzaRepository implements IPizzaRepository {

        private static za.ac.cput.repository.PizzaRepository repo = null;
        private Set<Pizza> pizzaDB;
        private PizzaRepository(){
            pizzaDB = new HashSet<Pizza>();
        }

        public static za.ac.cput.repository.PizzaRepository getRepo(){//singleton, having access to the private constructor
            if(repo == null){
                repo = new za.ac.cput.repository.PizzaRepository();
            }
            return repo;
        }

        @Override
        public Pizza create(Pizza pizza) {
            boolean success = pizzaDB.add(pizza);
            if(!success) {
                return null;
            }else {
                return pizza;
            }
        }

        @Override
        public Pizza read(String pizzaId) {
            for(Pizza p : pizzaDB){
                if(p.getPizzaId().equals(pizzaId))
                    return p;
            }
            return null;

        }

        @Override
        public Pizza update(Pizza pizza) {
            Pizza oldPizza = read(pizza.getPizzaId());
            if(oldPizza != null){
                pizzaDB.remove(oldPizza);
                pizzaDB.add(pizza);
                return pizza;
            }
            return null;
        }

        @Override
        public boolean delete(String pizzaId) {
            Pizza deletePizza = read(pizzaId);
            if(deletePizza != null){
                pizzaDB.remove(deletePizza);
                System.out.println("Could delete");
                return true;
            }else {
                System.out.println("Could not delete");
                return false;
            }
        }

        @Override
        public Set<Pizza> getAll(){return pizzaDB;}

    }


