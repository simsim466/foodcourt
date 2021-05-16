package web.restaurant;

import model.Restaurant;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = RestaurantController.RESTAURANT_USER, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController extends AbstractRestaurantController {
    static final String RESTAURANT_USER = "/restaurant/user";

    //то без возможности редактировать
    @Override
    @GetMapping("/{resId}")
    public Restaurant get(@PathVariable int resId) {
        return super.get(resId);
    }

    //то без возможности редактировать
    @Override
    @GetMapping
    public List<Restaurant> getAll() {
        return super.getAll();
    }
}
