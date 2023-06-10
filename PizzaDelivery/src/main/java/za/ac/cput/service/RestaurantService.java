package za.ac.cput.service;

import java.util.Set;
import za.ac.cput.domain.Restaurant;
import za.ac.cput.service.IService;

/*
 * RestaurantService.java
 * interface for the Restaurant Service
 * Author: Keenan Meyer - 220194920
 * Date: 09 June 2023
 */

public interface RestaurantService extends IService<Restaurant, String> {
    boolean delete(String restaurantNum);

    Set<Restaurant> getAll();
}