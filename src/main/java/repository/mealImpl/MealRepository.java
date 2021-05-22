package repository.mealImpl;

import model.menu.Meal;

import java.time.LocalDate;
import java.util.List;

public interface MealRepository {
    Meal save(Meal meal, int userId, int resId);
    Meal getWithRestaurant(int mealId, int resId, int userId);

    List<Object[]> getElectionResult(LocalDate date);

    List<Meal> getAllByRestaurant(int resId);
    Meal getActualByRestaurant(int resId, LocalDate date);//done
    List<Meal> getAllActual(LocalDate date);//done
    Boolean delete(int mealId, int userId, int resId);//done
}
