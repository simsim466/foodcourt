package web.restaurant;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import to.RestaurantTo;

import java.util.List;

import static util.RestaurantsUtil.*;

@RestController
@RequestMapping(value = RestaurantController.RESTAURANT_USER, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController extends AbstractRestaurantController {
    static final String RESTAURANT_USER = "/restaurants";

    @GetMapping("/{resId}")
    public RestaurantTo getForSimpleUser(@PathVariable int resId) {
        return asToWithMeal(super.get(resId), false);
    }

    @GetMapping
    public List<RestaurantTo> getAllForSimpleUser() {
        return asTos(super.getAll(), false);
    }
}
