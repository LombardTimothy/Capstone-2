package za.ac.cput.factory;

import za.ac.cput.domain.Pizza;
import za.ac.cput.domain.PizzaTopping;
import za.ac.cput.domain.Topping;
import za.ac.cput.util.Helper;
/* PizzaToppingFactory.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
public class PizzaToppingFactory {

    public static PizzaTopping buildPizzaTopping(Pizza pizzaId, Topping toppingId){
        if(Helper.isNullOrEmpty(String.valueOf(pizzaId)) || Helper.isNullOrEmpty(String.valueOf(toppingId))){
            return null;
        }

        PizzaTopping pt = new PizzaTopping.Builder().setPizza(pizzaId).setTopping(toppingId).build();
        return pt;
    }

}
