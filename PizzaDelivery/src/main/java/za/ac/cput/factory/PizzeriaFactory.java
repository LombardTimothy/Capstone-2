package za.ac.cput.factory;

import za.ac.cput.domain.Pizzeria;
import za.ac.cput.util.Helper;

/* PizzeriaFactory.java
   Entity for the PizzeriaFactory
   Author: Keenan Meyer (220194920)
   Date: 30th March 2023
*/
public class PizzeriaFactory {
    public static Pizzeria buildPizzaria(String pizzariaAlias,String location) {
        if (Helper.isNullOrEmpty(pizzariaAlias)  || Helper.isNullOrEmpty(String.valueOf(location))) {
            return null;
        }

        Integer pizzeriaID = Helper.generateId2();

        Pizzeria pizzeria = new Pizzeria.Builder()
                .setPizzariaID(pizzeriaID)
                .setPizzariaAlias(pizzariaAlias)
                .setLocation(location)
                .build();
        return pizzeria;

    }
}
