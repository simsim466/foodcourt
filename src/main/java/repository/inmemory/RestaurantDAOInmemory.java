package repository.inmemory;

import model.Restaurant;
import repository.RestaurantDAO;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RestaurantDAOInmemory implements RestaurantDAO {
    private final Map<Integer, Restaurant> repository = new ConcurrentHashMap<>();
    private final AtomicInteger index = new AtomicInteger(0);

    @Override
    public Restaurant save(Restaurant restaurant) {
        return null;
    }

    @Override
    public boolean delete(int resId) {
        return false;
    }

    @Override
    public List<Restaurant> getAll() {
        return null;
    }

    @Override
    public Restaurant get(int resId) {
        return null;
    }
}
