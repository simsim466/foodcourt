package web.restaurant;

import model.Restaurant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import service.RestaurantService;

import java.util.List;

public abstract class AbstractRestaurantController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantService service;

    public Restaurant get(int resId) {
        log.info("get with {}", resId);
        return service.get(resId);
    }

    public List<Restaurant> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public List<Restaurant> getAllForUser(int userId) {
        log.info("getAll for user");
        return service.getAllForUser(userId);
    }

    public Restaurant getForUser(int resId, int userId) {
        log.info("get {} for user {}", resId, userId);
        return service.getForUser(resId, userId);
    }

    //что resId и res одного поля ягоды
    public void update(Restaurant restaurant, int resId, int userId) {
        log.info("update {} with {} for user {}", restaurant, resId, userId);
        service.create(restaurant, userId);
    }

    public Restaurant create(Restaurant restaurant, int userId) {
        log.info("create {} by user {}", restaurant, userId);
        return service.create(restaurant, userId);
    }

    public void delete(int resId, int userId) {
        log.info("delete restaurant {} for user {}", resId, userId);
        service.delete(resId, userId);
    }
}
