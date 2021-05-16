package repository.restaurantImpl;

import model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    Restaurant save(Restaurant restaurant, int userId);
    boolean delete(int resId, int userId);
    Restaurant get(int resId);
    Restaurant getForUser(int resId, int userId);
    List<Restaurant> getAllForUser(int userId);
    List<Restaurant> getAll();
}
