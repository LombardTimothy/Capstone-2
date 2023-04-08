package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Restaurant;
import static org.junit.jupiter.api.Assertions.assertNotNull;
class RestaurantFactoryTest {
    @Test
    void buildRestaurant() {
        Restaurant restaurant = RestaurantFactory.buildRestaurant("Hill Crest",12,  true);
        System.out.println(restaurant.toString());
        assertNotNull(restaurant);
    }
}
