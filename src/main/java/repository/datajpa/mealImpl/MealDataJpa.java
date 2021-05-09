package repository.datajpa.mealImpl;

import model.Meal;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.MealRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class MealDataJpa implements MealRepository {
    private final CrudMealRepository mealRepository;
    private final CrudRestaurantRepository restaurantRepository;

    public MealDataJpa(CrudMealRepository mealRepository, CrudRestaurantRepository restaurantRepository) {
        this.mealRepository = mealRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    @Transactional//done
    public Meal save(Meal meal, int userId, int resId) {
        /*if ( restaurantRepository.getCreatorId(resId) != userId) {
            return null;
        }*/
        if (!meal.isNew() && getWithRestaurant(meal.getId(), resId, userId) == null) {
            return null;
        }
        meal.setRestaurant(restaurantRepository.getById(resId));
        return mealRepository.save(meal);
    }
    @Override//done without restaurant
    public Meal get(int mealId) {
        return mealRepository.findById(mealId).orElse(null);
    }

    @Override//done
    public Meal getWithRestaurant(int mealId, int resId, int userId) {
        return mealRepository.getWithRestaurant(mealId, resId, userId);
    }

    @Override//done
    public List<Meal> getAllActual() {
        LocalDate today = LocalDate.now();
        return mealRepository.findMealsByDate(today);
    }

    @Override//done but what about dishes
    public boolean delete(int mealId, int resId, int userId) {
        return mealRepository.delete(mealId, resId, userId) != 0;
    }
}
