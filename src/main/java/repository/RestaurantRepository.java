package repository;

import model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    Restaurant save(Restaurant restaurant, int userId);
    boolean delete(int resId, int userId);
    Restaurant get(int resId, int userId);
    List<Restaurant> getAll(int userId);
}
