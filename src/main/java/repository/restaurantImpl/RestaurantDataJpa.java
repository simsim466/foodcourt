package repository.restaurantImpl;

import model.Restaurant;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.userImpl.CrudUserRepository;

import java.util.List;

@Repository//по возможности сделать получение ресторана с едой (@EntityGraph)
public class RestaurantDataJpa implements RestaurantRepository {
    private final CrudRestaurantRepository restaurantRepository;
    private final CrudUserRepository userRepository;

    public RestaurantDataJpa(CrudRestaurantRepository restaurantRepository, CrudUserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    //владелец сохраняет ресторан
    public Restaurant save(Restaurant restaurant, int userId) {
        if (!restaurant.isNew() && getForUser(restaurant.id(), userId) == null) {
            return null;
        }
        restaurant.setCreator(userRepository.findById(userId).orElse(null));
        return restaurantRepository.save(restaurant);
    }

    @Override
    @Transactional
    //владелец удаляет ресторан
    //есть две версии в репо
    public boolean delete(int resId, int userId) {
        return restaurantRepository.delete(resId,userId) != 0;
    }

    @Override
    //пользователь смотрит все рестораны
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Override
    //пользователь хочет посмотреть ресторан с инфой о владельце и текущей еде
    public Restaurant get(int resId) {
        return restaurantRepository.getWithUser(resId).orElse(null);
    }

    @Override
    //владелец хочет посмотреть свой ресторан с текущей едой
    public Restaurant getForUser(int resId, int userId) {
        return restaurantRepository.findRestaurantByIdAndCreator_Id(resId, userId).orElse(null);
    }

    @Override
    //владалец смотрит свои рестораны
    //есть две версии в репо
    public List<Restaurant> getAllForUser(int userId) {
        return restaurantRepository.getAllByUserId(userId);
    }
}
