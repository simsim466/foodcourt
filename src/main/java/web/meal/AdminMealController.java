package web.meal;

import model.menu.Meal;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import to.MealTo;

import java.net.URI;

import static util.MealsUtil.*;
import static util.ValidationUtil.*;

@RestController
@RequestMapping(value = AdminMealController.ADMIN_MEAL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminMealController extends AbstractMealController {
    static final String ADMIN_MEAL = "/admin/{userId}/restaurants/{resId}/meals";

    @GetMapping("/{mealId}")
    public MealTo get(@PathVariable int mealId, @PathVariable int resId, @PathVariable int userId) {
        return asToWithRestaurant(super.getWithRestaurant(mealId, resId, userId));
    }

    @DeleteMapping("/{mealId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int mealId, @PathVariable int resId, @PathVariable int userId) {
        super.delete(mealId, resId, userId);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> createWithLocation(@RequestBody MealTo mealTo,
                                                   @PathVariable int resId, @PathVariable int userId) {
        checkNew(mealTo);
        Meal created = super.create(createFromTo(mealTo), resId, userId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/admin/" + userId + "/restaurants/" + resId + "/meals/" + "{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{mealId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody MealTo mealTo, @PathVariable int mealId,
                       @PathVariable int resId, @PathVariable int userId) {
        assureIdConsistent(mealTo, mealId);
        super.create(convertFromTo(mealTo), resId, userId);
    }
}
