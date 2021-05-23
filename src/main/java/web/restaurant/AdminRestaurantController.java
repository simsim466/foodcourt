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
    static final String RESTAURANT_ADMIN = "/admin/{userId}/restaurants";

    @DeleteMapping("/{resId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int resId, @PathVariable int userId) {
        super.delete(resId, userId);
    }

    @GetMapping
    public List<RestaurantTo> allForUser(@PathVariable int userId) {
        return RestaurantsUtil.asTos(super.getAllForUser(userId), true);
    }

    @GetMapping("/{resId}")
    public RestaurantTo forUser(@PathVariable int resId, @PathVariable int userId) {
        return RestaurantsUtil.asTo(super.getForUser(resId, userId), true);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> createWithLocation(@RequestBody RestaurantTo resTo, @PathVariable int userId) {
        Restaurant created = super.create(resTo, userId);
        URI uriOfNewEntity = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/admin/" + userId + "/restaurants" + "/{id}")
                .buildAndExpand(created.id()).toUri();
        return ResponseEntity.created(uriOfNewEntity).body(created);
    }

    @PutMapping("/{resId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody RestaurantTo resTo,@PathVariable int resId, @PathVariable int userId) {
        super.update(resTo, resId, userId);
    }
}
