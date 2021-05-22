package repository.restaurantImpl;

import model.Restaurant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import service.RestaurantService;
import to.RestaurantTo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class RestaurantDataJpaTest {
    @Autowired
    private RestaurantService service;

    @Test
    void save() {
        RestaurantTo restaurant = new RestaurantTo("Плакучая ива");
        Restaurant restaurant1 = service.save(restaurant, 1001);
        System.out.println(restaurant1);
    }

    @Test
    void delete() {
        Restaurant restaurantBefore = service.get(1017);
        System.out.println(restaurantBefore);
        service.delete(1017, 1012);
        Restaurant restaurantAfter = service.get(1017);
        System.out.println(restaurantAfter);
    }

    @Test
    void get() {
        Restaurant restaurant = service.get(1017);
        System.out.println(restaurant);
    }

    @Test
    void getAll() {
        Set<Restaurant> restaurants = new HashSet<>(service.getAll());
        System.out.println(restaurants);
    }

    @Test
    void getForUser() {
        Restaurant restaurant = service.getForUser(1017, 1012);
        System.out.println(restaurant);
    }

    @Test
    void getAllForUser() {
        List<Restaurant> restaurants = service.getAllForUser(1012);
        System.out.println(restaurants);
    }
}