package za.ac.cput.factory;

import za.ac.cput.domain.Topping;
import za.ac.cput.util.Helper;
/* ToppingFactory.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
public class ToppingFactory {

    public static Topping buildTopping(String toppingName, String toppingDescription, int toppingQuantity, double toppingPrice ){
        if(Helper.isNullOrEmpty(toppingName) || Helper.isNullOrEmpty(toppingDescription) || Helper.isNullOrEmpty(String.valueOf(toppingQuantity)) || Helper.isNullOrEmpty(String.valueOf(toppingPrice))){
            return null;
        }

        String toppingId = Helper.generateId();

        Topping t = new Topping.Builder().setToppingId(toppingId).setToppingName(toppingName).setToppingDescription(toppingDescription).setToppingQuantity(toppingQuantity).setToppingPrice(toppingPrice).build();
        return t;
    }
}
