package util;

import model.Restaurant;
import model.menu.Meal;
import to.RestaurantTo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantsUtil {
    public static RestaurantTo asTo(Restaurant restaurant, boolean enable) {
        return new RestaurantTo(restaurant.getId(), restaurant.getName(), enable);
    }
    //для юзера с информацией и о владельце и о текущей еде
    public static RestaurantTo asToWithUser(Restaurant restaurant) {
        RestaurantTo restaurantTo = asTo(restaurant, false);
        restaurantTo.setCreator(UsersUtil.asTo(restaurant.getCreator()));
        return restaurantTo;
    }
    //только с текущей едой для владельца
    public static RestaurantTo asToWithMeal(Restaurant restaurant, boolean enable) {
        RestaurantTo restaurantTo = asTo(restaurant, enable);
        Meal meal = restaurant.getMeals()
                .stream()
                .filter(m -> m.getDate().isEqual(LocalDate.now()))
                .findAny()
                .orElse(null);
        if (meal != null) {
            restaurantTo.setMealTo(MealsUtil.asTo(meal));
        }
        return restaurantTo;
    }
    //список возвращаем и владельцу и всем
    public static List<RestaurantTo> asTos(Collection<Restaurant> restaurants, boolean enable) {
        return restaurants.stream()
                .map(res -> asTo(res, enable))
                .collect(Collectors.toList());
    }

    public static Restaurant convertToRestaurant(RestaurantTo restaurantTo) {
        Integer id = restaurantTo.getId();
        String name = restaurantTo.getName();
        return new Restaurant(id, name);

    }

    private RestaurantsUtil() {
    }
}
