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

    public static PizzaTopping buildPizzaTopping(Pizza pizza, Topping topping){

        String pizzaId = pizza.getPizzaId();
        String toppingId = topping.getToppingId();

        PizzaTopping pt = new PizzaTopping.Builder().setPizzaId(pizzaId).setToppingId(toppingId).build();
        return pt;
    }


    public static  Pizza createPizza(){
        String pizzaId = Helper.generateId();

        Pizza p = new Pizza.Builder().setPizzaId(pizzaId).build();
        return p;
    }

    public static Topping createTopping(){
        String toppingId = Helper.generateId();

        Topping t = new Topping.Builder().setToppingId(toppingId).build();
        return t;
    }

}
