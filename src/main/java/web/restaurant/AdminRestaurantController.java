package web.restaurant;

import model.Restaurant;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = AdminRestaurantController.RESTAURANT_ADMIN, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestaurantController extends AbstractRestaurantController {
    static final int ADMIN_ID = 1012;
    static final String RESTAURANT_ADMIN = "/restaurant/admin";

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        super.delete(id, ADMIN_ID);
    }

    //сделать ТО с возможностью редактирования
    @GetMapping
    public List<Restaurant> getAllForUser() {
        return super.getAllForUser(ADMIN_ID);
    }

    //сделать ТО с возможностью редактирования
    @GetMapping("/{resId}")
    public Restaurant getForUser(@PathVariable int resId, int userId) {
        return super.getForUser(resId, ADMIN_ID);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> createWithLocation(@RequestBody Restaurant restaurant) {
        Restaurant created = super.create(restaurant, ADMIN_ID);
        URI uriOfNewEntity = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(RESTAURANT_ADMIN + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewEntity).body(created);
    }

    @PutMapping("/{resId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Restaurant restaurant,@PathVariable int resId) {
        super.update(restaurant, resId, ADMIN_ID);
    }
}
