package repository.mealImpl;

import model.Meal;

import java.util.List;

public interface MealRepository {
    Meal save(Meal meal, int userId, int resId);
    Meal get(int mealId);
    Meal getActualByRestaurant(int resId);
    Meal getWithRestaurant(int mealId, int resId, int userId);
    List<Meal> getAllActual();
    boolean delete(int mealId, int userId, int resId);
}
