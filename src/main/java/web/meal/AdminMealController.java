package web.meal;

import model.Meal;
import model.Restaurant;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = AdminMealController.ADMIN_MEAL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminMealController extends AbstractMealController {
    static final String ADMIN_MEAL = "/meal/admin";
    static final int ADMIN_ID = 10;

    @GetMapping("/{mealId}/{resId}")
    public Meal getWithRestaurant(@PathVariable int mealId, @PathVariable int resId) {
        return super.getWithRestaurant(mealId, resId, ADMIN_ID);
    }

    @DeleteMapping("/{mealId}/{resId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int mealId, @PathVariable int resId) {
        super.delete(mealId, resId, ADMIN_ID);
    }

    @PutMapping(value = "/{resId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> createWithLocation(@RequestBody Meal meal, @PathVariable int resId) {
        Meal created = super.create(meal, resId, ADMIN_ID);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(ADMIN_MEAL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping("/{resId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Meal meal, @PathVariable int resId) {
        super.create(meal, resId, ADMIN_ID);
    }
}
