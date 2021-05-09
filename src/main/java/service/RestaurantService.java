package service;

import repository.RestaurantRepository;

//@Service
public class RestaurantService {
    private RestaurantRepository repository;
/*
    public RestaurantService(RestaurantRepository repository)  {
        this.repository = repository;
    }
    //проверить входные на null
    public void update(Restaurant restaurant, int userId)   {
        repository.save(restaurant, userId);
    }
    //проверить входные на null
    public Restaurant create(Restaurant restaurant, int userId) {
        return repository.save(restaurant, userId);
    }
    //проверить результат удалось ли найти
    public void delete(int id, int userId)  {
        repository.delete(id, userId);
    }
    //проверить результат удалось ли найти
    public Restaurant get(int resId)    {
        return repository.get(resId);
    }

    public List<Restaurant> getAll()    {
        return null;
    }*/
}
