package util;

import model.menu.Meal;
import to.MealTo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static util.DateTimeUtil.*;

public class MealsUtil {
    public static MealTo asTo(Meal meal) {
        MealTo to = new MealTo(meal.getId(), meal.getAllDishes(), meal.getDate());
        to.setCurrent(isToday(to.getDate()) && !isLateNow());
        return to;
    }

    private static MealTo asToWithVotesNumber(Meal meal, int votesNumber) {
        MealTo to = asTo(meal);
        to.setVotesNumber(votesNumber);
        return to;
    }
    //булево с рестораном может нафиг
    public static MealTo asToWithRestaurant(Meal meal) {
        MealTo mealTo = asTo(meal);
        mealTo.setRestaurant(RestaurantsUtil.asTo(meal.getRestaurant(), false));
        return mealTo;
    }

    public static List<MealTo> asTosWithVotesNumber(List<Object[]> objects) {
        return objects.stream()
                .map(objects1 -> asToWithVotesNumber((Meal) objects1[0], (int) objects1[1]))
                .collect(Collectors.toList());
    }

    public static List<MealTo> asTos(Collection<Meal> meals) {
        return meals.stream()
                .map(meal -> asTo(meal))
                .collect(Collectors.toList());
    }

    public static List<MealTo> asTosWithRestaurant(Collection<Meal> meals) {
        return meals.stream()
                .map(meal -> asToWithRestaurant(meal))
                .collect(Collectors.toList());
    }

    public static Meal createFromTo(MealTo mealTo) {
        return new Meal(mealTo.getDishes(), isLateNow() ? tomorrow() : today());
    }

    public static Meal convertFromTo(MealTo mealTo) {
        return new Meal(mealTo.getId(), mealTo.getDishes(), mealTo.getDate());
    }

    private MealsUtil() {
    }
}
