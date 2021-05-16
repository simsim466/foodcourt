package web.meal;

import model.Meal;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = UserMealController.USER_MEAL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserMealController extends AbstractMealController {
    static final String USER_MEAL = "/meals/user";

    @Override
    @GetMapping("/{mealId}")
    public Meal get(@PathVariable int mealId) {
        return super.get(mealId);
    }

    @Override
    @GetMapping
    public List<Meal> getAllActual() {
        return super.getAllActual();
    }

    @Override
    @GetMapping("/meal-of-restaurant/{resId}")
    public Meal getActualByRestaurant(@PathVariable int resId) {
        return super.getActualByRestaurant(resId);
    }
}
