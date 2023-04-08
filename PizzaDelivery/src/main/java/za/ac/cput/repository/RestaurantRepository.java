package za.ac.cput.repository;

import java.util.HashSet;
import java.util.Set;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Restaurant;

/*
   CustomerRepository.java
   Repository for the Customer class
   Author: Keenan Meyer (220194920)
   Date: 4th April 2023
*/
public class RestaurantRepository implements IRestaurantRepository{

    private static RestaurantRepository repository = null;
    private Set<Restaurant> restaurantList = null;

    private RestaurantRepository()
    {
        restaurantList = new HashSet<Restaurant>();
    }
    public static RestaurantRepository getRepository(){
        if(repository == null)
            repository = new RestaurantRepository();
        return repository;
    }
    @Override
    public Restaurant create(Restaurant restaurant) {
        boolean success = restaurantList.add(restaurant);
        if(!success)
            return null;
        return restaurant;
    }

    @Override
    public Restaurant read(String restaurantId) {
        for (Restaurant e: restaurantList
        ) {
            if(e.getRestaurantID().equals(restaurantId))
                return e;


        } return null;
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        Restaurant buffer = read(restaurant.getRestaurantID());
        if(buffer != null) {
            restaurantList.remove(buffer);
            restaurantList.add(restaurant);
            return restaurant;
        }
        return null;
    }

    @Override
    public boolean delete(String restaurantID) {
        Restaurant restaurant = read(restaurantID);
        if(restaurant == null)
            return false;
        restaurantList.remove(restaurant);
        return true;
    }
    @Override
    public Set<Restaurant> getAll() {
        return null;
    }

}
