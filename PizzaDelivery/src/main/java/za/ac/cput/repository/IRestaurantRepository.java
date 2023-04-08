package za.ac.cput.repository;


import java.util.Set;
import za.ac.cput.domain.Restaurant;

public interface IRestaurantRepository extends IRepository<Restaurant, String> {
    public Set<Restaurant> getAll();
}
