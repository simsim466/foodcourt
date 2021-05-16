package repository.restaurantImpl;

import model.Restaurant;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.userImpl.CrudUserRepository;

import java.util.List;

@Repository
public class RestaurantDataJpa implements RestaurantRepository {
    private final CrudRestaurantRepository restaurantRepository;
    private final CrudUserRepository userRepository;

    public RestaurantDataJpa(CrudRestaurantRepository restaurantRepository, CrudUserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant, int userId) {
        if (!restaurant.isNew() && getForUser(restaurant.id(), userId) == null) {
            return null;
        }
        restaurant.setCreator(userRepository.findById(userId).orElse(null));
        return restaurantRepository.save(restaurant);
    }

    @Override
    public boolean delete(int resId, int userId) {
        return restaurantRepository.delete(resId,userId) != 0;
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant get(int resId) {
        return restaurantRepository.findById(resId).orElse(null);
    }

    @Override
    public Restaurant getForUser(int resId, int userId) {
        return restaurantRepository.findById(resId)
                .filter(restaurant -> restaurant.getCreator().getId() == userId)
                .orElse(null);
    }

    @Override
    public List<Restaurant> getAllForUser(int userId) {
        return restaurantRepository.getAllByUserId(userId);
    }
}
