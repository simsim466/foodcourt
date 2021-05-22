package web.meal;

import model.menu.Meal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import service.MealService;

import java.time.LocalDate;
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

    //проверить имеет ли право этот пользователь создавать еду
    //проверить имеем ли мы право создавать еду в этот день в этом ресторане
    public Meal create(Meal meal, int resId, int userId)   {
        log.info("create {} in restaurant {} by user {}", meal, resId, userId);
        return service.create(meal, resId, userId);
    }

    public List<Meal> getAllActual(LocalDate date)    {
        log.info("getAllActual");
        return service.getAllActual(date);
    }

    public Meal getActualByRestaurant(int resId, LocalDate date) {
        log.info("get by restaurant {} on {}", resId, date);
        return service.getActualByRestaurant(resId, date);
    }

    public List<Meal> getAllByRestaurant(int resId) {
        log.info("getAll by restaurant {}", resId);
        return service.getAllByRestaurant(resId);
    }

    public List<Object[]> electionResults(LocalDate date) {
        log.info("get election results on {}", date);
        return service.getElectionResult(date);
    }
}
