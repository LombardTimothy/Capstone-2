package za.ac.cput.factory;

import za.ac.cput.domain.Pizzeria;
import za.ac.cput.util.Helper;

/* PizzeriaFactory.java
   Entity for the PizzeriaFactory
   Author: Keenan Meyer (220194920)
   Date: 30th March 2023
*/
public class PizzeriaFactory {
    public static Pizzeria buildRestaurant(String restaurantName, int noOfEmp, boolean isOpen) {
        if (Helper.isNullOrEmpty(restaurantName) || noOfEmp == 0 || Helper.isNullOrEmpty(String.valueOf(isOpen))) {
            return null;
        }

        String restaurantID = Helper.generateId();

        Pizzeria pizzeria = new Pizzeria.Builder().
                setRestaurantID(restaurantID).
                setRestaurantName(restaurantName).
                setNoOfEmp(noOfEmp).
                setIsOpen(isOpen).build();
        return pizzeria;

    }
}
