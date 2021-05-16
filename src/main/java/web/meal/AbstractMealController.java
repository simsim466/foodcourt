package web.meal;

import model.Meal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import repository.mealImpl.MealRepository;
import service.MealService;

import java.util.List;

public class AbstractMealController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;

    public Meal getWithRestaurant(int mealId, int resId, int userId) {
        log.info("get {} of restaurant {} for owner {}", mealId, resId, userId);
        return service.getWithRestaurant(mealId, resId, userId);
    }

    public void delete(int mealId, int resId, int userId) {
        log.info("delete meal {} of restaurant {} and user {}", mealId, resId, userId);
        service.delete(mealId, resId, userId);
    }

    public Meal get(int mealId) {
        log.info("get meal {}", mealId);
        return service.get(mealId);
    }

    //проверить имеет ли право этот пользователь создавать еду
    //проверить имеем ли мы право создавать еду в этот день в этом ресторане
    public Meal create(Meal meal, int resId, int userId)   {
        log.info("create {} in restaurant {} by user {}", meal, resId, userId);
        return service.create(meal, resId, userId);
    }

    public List<Meal> getAllActual()    {
        log.info("getAllActual");
        return service.getAllActual();
    }

    public Meal getActualByRestaurant(int resId) {
        log.info("get actual for restaurant {}", resId);
        return service.getActualByRestaurant(resId);
    }
}
