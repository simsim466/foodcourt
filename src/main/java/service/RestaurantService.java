package service;

import model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.restaurantImpl.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository repository;

    @Autowired
    public RestaurantService(RestaurantRepository repository)  {
        this.repository = repository;
    }

    //проверить результат удалось ли найти
    public Restaurant get(int resId)    {
        return repository.get(resId);
    }

    public List<Restaurant> getAll()    {
        return repository.getAll();
    }

    public Restaurant getForUser(int resId, int userId) {
        return repository.getForUser(resId, userId);
    }

    public List<Restaurant> getAllForUser(int userId)    {
        return repository.getAllForUser(userId);
    }

    //проверить результат удалось ли найти
    public void delete(int resId, int userId)  {
        repository.delete(resId, userId);
    }

    //проверить входные на null
    public Restaurant create(Restaurant restaurant, int userId) {
        return repository.save(restaurant, userId);
    }

    //проверить входные на null
    public void update(Restaurant restaurant, int userId)   {
        repository.save(restaurant, userId);
    }
}
