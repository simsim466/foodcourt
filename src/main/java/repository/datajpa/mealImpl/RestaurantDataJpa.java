package repository.datajpa.mealImpl;

import model.Restaurant;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.RestaurantRepository;

import java.util.List;

@Repository
public class RestaurantDataJpa implements RestaurantRepository {
    private final CrudRestaurantRepository restaurantRepository;
    private final CrudUserRepository userRepository;

    public RestaurantDataJpa(CrudRestaurantRepository restaurantRepository, CrudUserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @Override//done
    @Transactional
    public Restaurant save(Restaurant restaurant, int userId) {
        if (!restaurant.isNew() && get(restaurant.id(), userId) == null) {
            return null;
        }
        restaurant.setCreator(userRepository.getById(userId));
        return restaurantRepository.save(restaurant);
    }

    @Override//done
    public boolean delete(int resId, int userId) {
        return restaurantRepository.delete(resId,userId) != 0;
    }

    @Override//done
    public Restaurant get(int resId, int userId) {
        return restaurantRepository.findById(resId)
                .filter(restaurant -> restaurant.getId() == userId)
                .orElse(null);
    }

    @Override//done
    public List<Restaurant> getAll(int userId) {
        return restaurantRepository.getAll(userId);
    }
}
