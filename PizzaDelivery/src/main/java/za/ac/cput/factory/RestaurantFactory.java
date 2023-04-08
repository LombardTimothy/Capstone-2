package za.ac.cput.factory;

import za.ac.cput.domain.Restaurant;
import za.ac.cput.util.Helper;

/* RestaurantFactory.java
   Entity for the RestaurantFactory
   Author: Keenan Meyer (220194920)
   Date: 30th March 2023
*/
public class RestaurantFactory {
    public static Restaurant buildRestaurant(String restaurantName, int noOfEmp, boolean isOpen) {
        if (Helper.isNullOrEmpty(restaurantName) || noOfEmp == 0 || Helper.isNullOrEmpty(String.valueOf(isOpen))) {
            return null;
        }

        String restaurantID = Helper.generateId();

        Restaurant restaurant = new Restaurant.Builder().
                setRestaurantID(restaurantID).
                setRestaurantName(restaurantName).
                setNoOfEmp(noOfEmp).
                setIsOpen(isOpen).build();
        return restaurant;

    }
}
