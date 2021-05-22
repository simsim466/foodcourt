package web.meal;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import to.MealTo;

import java.time.LocalDate;
import java.util.List;

import static util.MealsUtil.*;

@RestController
@RequestMapping(value = UserMealController.USER_MEAL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserMealController extends AbstractMealController {
    static final String USER_MEAL = "/user/meals";

    @GetMapping("/date")
    //посмотреть все актуальные по дате с рестораном - DONE
    public List<MealTo> getAll(@RequestParam LocalDate date) {
        return asTosWithRestaurant(super.getAllActual(date));
    }

    @GetMapping("/date/{resId}")
    //done
    public MealTo getByRestaurant(@PathVariable int resId, @RequestParam LocalDate date) {
        return asTo(super.getActualByRestaurant(resId, date));
    }

    @GetMapping("/by-restaurant/{resId}")
    //done
    public List<MealTo> getAllForRestaurant(@PathVariable int resId) {
        return asTos(super.getAllByRestaurant(resId));
    }

    @GetMapping("/results")
    public List<MealTo> getElectionResults(@RequestParam LocalDate date) {
        return asTosWithVotesNumber(super.electionResults(date));
    }
}
