package web;

import model.Meal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.MealService;

import java.util.List;

//@Controller
public class MealController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    //получить userId в SecurityUtil

    //@Autowired
    private MealService service;

    public Meal get(int mealId) {
        log.info("get meal {}", mealId);
        return service.get(mealId);
    }

    public void delete(int mealId)  {
        int userId = 0;
        log.info("delete meal {} for user {}", mealId, userId);
        //service.delete(mealId, userId);
    }

    //проверить имеет ли право этот пользователь создавать еду
    //проверить новая ли еда
    //проверить имеем ли мы право создавать еду в этот день в этом ресторане
    public Meal create(Meal meal)   {
        int userId = 0;
        log.info("create {} by user {}", meal, userId);
        return null;//service.create(meal, userId);
    }

    //проверить может ли пользователь менять эту еду
    //проверить можно ли изменить еду
    public void update(Meal meal)   {
        int userId = 0;
        log.info("update {} with user {}", meal, userId);
        //service.update(meal, userId);
    }

    public List<Meal> getAllActual()    {
        log.info("getAllActual");
        return service.getAllActual();
    }
    //проверить на актуальность
    //удалось ли проголосовать
    public void vote(int mealId)    {
        int userId = 0;
        log.info("vote for meal {} by user {}", mealId, userId);
        //service.vote(mealId, userId);
    }
}
