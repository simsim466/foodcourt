package service;

import model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.restaurantImpl.RestaurantRepository;
import to.RestaurantTo;
import util.RestaurantsUtil;

import java.util.List;

import static util.ValidationUtil.*;

@Service
public class RestaurantService {
    private final RestaurantRepository repository;

    @Autowired
    public RestaurantService(RestaurantRepository repository)  {
        this.repository = repository;
    }

    //done
    public Restaurant get(int resId)    {
        return checkNotFoundWithId(repository.get(resId), resId);
    }
    //done
    public List<Restaurant> getAll()    {
        return repository.getAll();
    }
    //done
    public Restaurant getForUser(int resId, int userId) {
        return checkNotFound(repository.getForUser(resId, userId),
                "id=" + resId + "which belongs to user " + userId);
    }
    //done
    public List<Restaurant> getAllForUser(int userId)    {
        return repository.getAllForUser(userId);
    }

    //done, но хотелось бы разделить что нет такого ресторана с тем, что у него нет пользователя
    public void delete(int resId, int userId)  {
        checkNotFoundWithId(repository.delete(resId, userId), resId);
    }
    //done
    public Restaurant save(RestaurantTo resTo, int userId) {
        Assert.notNull(resTo, "restaurant must not be null");
        Restaurant result = checkNotFound(repository.save(RestaurantsUtil.convertToRestaurant(resTo), userId), "Restaurant " + resTo.getName());
        checkNotFoundWithId(result.getCreator(), userId);
        return result;
    }
}
