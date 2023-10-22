package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Pizza;
//import za.ac.cput.domain.PizzaTopping;
//import za.ac.cput.domain.PizzaToppingId;
import za.ac.cput.domain.Topping;

import java.util.ArrayList;
import java.util.Set;
/* IPizzaToppingRepository.java
 Author: Timothy Lombard (220154856)
 Date: 24th July (last updated) 2023

@Repository
public interface IPizzaToppingRepository extends JpaRepository<PizzaTopping, PizzaToppingId> {

    public ArrayList<PizzaTopping> findAllByPizzaIdAndToppingId(Pizza pizzaId, Topping toppingId);

    public void deleteAllByPizzaIdAndToppingId(Pizza pizzaId, Topping toppingId);

}

 */
