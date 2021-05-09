package web;

import model.Restaurant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.RestaurantService;

import java.util.List;

//@Controller
public class RestaurantController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    //@Autowired
    private RestaurantService service;

    //получить userId в SecurityUtil

    //проверить id - точно ли это тот ресторан
    public void update(Restaurant restaurant, int id) {
        int userId = 0;
        log.info("update {} for user {}", restaurant, userId);
        //service.update(restaurant, userId);
    }

    //проверить новый ли ресторан
    public Restaurant create(Restaurant restaurant) {
        int userId = 0;
        log.info("create {} for user {}", restaurant, userId);
        return null;//service.create(restaurant, userId);
    }

    public void delete(int id)  {
        int userId = 0;
        log.info("delete restaurant {}", id);
        //service.delete(id, userId);
    }

    public Restaurant get(int id) {
        log.info("get restaurant {}", id);
        return null;//service.get(id);
    }

    public List<Restaurant> getAll()    {
        log.info("get all restaurants");
        return null;
    }
}
