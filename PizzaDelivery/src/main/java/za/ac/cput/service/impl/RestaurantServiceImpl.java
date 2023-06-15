package za.ac.cput.service.impl;

import java.util.Set;

import za.ac.cput.domain.Pizza;
import za.ac.cput.domain.Restaurant;
import za.ac.cput.repository.RestaurantRepository;
import za.ac.cput.service.RestaurantService;

/*
 * RestaurantServiceImpl.java
 * Service for the Restaurant Implimentation
 * Author: Keenan Meyer - 220194920
 * Date: 09 June 2023
 */
public class RestaurantServiceImpl implements RestaurantService {


    private static RestaurantServiceImpl service = null;
    private static RestaurantRepository repository = null;

    private RestaurantServiceImpl() {
        if (repository == null) {
            repository = RestaurantRepository.getRepository();
        }
    }

    public static RestaurantServiceImpl getService() {
        if (service == null) {
            service = new RestaurantServiceImpl();
        }
        return service;
    }


    @Override
    public Restaurant create(Restaurant restaurant) {
        Restaurant readRestaurant = repository.create(restaurant);
        return readRestaurant;
    }

    @Override
    public Restaurant read(String id) {
        Restaurant read = repository.read(id);
        return read;
    }

    @Override
    public Restaurant update(Restaurant employeeNum) {
        Restaurant updated = repository.update(employeeNum);
        return updated;
    }

    @Override
    public boolean delete(String restaurantNum) {
        boolean success = repository.delete(String.valueOf(restaurantNum));
        return success;
    }

    @Override
    public Set<Restaurant> getAll() {
        return repository.getAll();
    }
}

