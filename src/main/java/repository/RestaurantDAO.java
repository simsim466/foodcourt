package repository;

import model.Restaurant;

import java.util.List;

public interface RestaurantDAO {
    Restaurant save(Restaurant restaurant);
    boolean delete (int resId);
    List<Restaurant> getAll();
    Restaurant get(int resId);

}
