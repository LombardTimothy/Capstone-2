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

    public static PizzaTopping buildPizzaTopping( ){

        String pizzaId = Helper.generateId();
        String toppingId = Helper.generateId();

        PizzaTopping pt = new PizzaTopping.Builder().setPizzaId(pizzaId).setToppingId(toppingId).build();
        return pt;
    }
}
