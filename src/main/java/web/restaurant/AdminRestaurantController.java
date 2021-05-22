package web.restaurant;

import model.Restaurant;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import to.RestaurantTo;
import util.RestaurantsUtil;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = AdminRestaurantController.RESTAURANT_ADMIN, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestaurantController extends AbstractRestaurantController {
    static final int ADMIN_ID = 1012;
    static final String RESTAURANT_ADMIN = "/admin/restaurants";
    //done
    @DeleteMapping("/{resId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int resId) {
        super.delete(resId, ADMIN_ID);
    }
    //done
    @GetMapping
    public List<RestaurantTo> getAllForUser() {
        return RestaurantsUtil.asTos(super.getAllForUser(ADMIN_ID), true);
    }
    //done
    @GetMapping("/{resId}")
    public RestaurantTo getForUser(@PathVariable int resId) {
        return RestaurantsUtil.asToWithMeal(super.getForUser(resId, ADMIN_ID), true);
    }
    //done
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> createWithLocation(@RequestBody RestaurantTo resTo) {
        Restaurant created = super.create(resTo, ADMIN_ID);
        URI uriOfNewEntity = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(RESTAURANT_ADMIN + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewEntity).body(created);
    }
    //done
    @PutMapping("/{resId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody RestaurantTo resTo,@PathVariable int resId) {
        super.update(resTo, resId, ADMIN_ID);
    }
}
