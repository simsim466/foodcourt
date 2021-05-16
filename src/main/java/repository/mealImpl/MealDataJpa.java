package repository.mealImpl;

import model.Meal;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.restaurantImpl.CrudRestaurantRepository;

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
    @Transactional
    public Meal save(Meal meal, int userId, int resId) {
        if ( restaurantRepository.getCreatorId(resId).get(0) != userId) {
            return null;
        }
        if (!meal.isNew() && getWithRestaurant(meal.getId(), resId, userId) == null) {
            return null;
        }
        LocalDate now = LocalDate.now();
        if (mealRepository.existsMealByDateAndRestaurantId(now, resId)) {
            return null;//проверить можно ли с помощью COUNT
        }
        meal.setRestaurant(restaurantRepository.getById(resId));
        meal.setDate(now);
        return mealRepository.save(meal);
    }
    @Override
    public Meal get(int mealId) {
        return mealRepository.findById(mealId).orElse(null);
    }

    @Override
    public Meal getWithRestaurant(int mealId, int resId, int userId) {
        return mealRepository.getWithRestaurant(mealId, resId, userId).orElse(null);
    }

    @Override
    public List<Meal> getAllActual() {
        LocalDate today = LocalDate.now();
        return mealRepository.findMealsByDate(today);
    }

    @Override
    public boolean delete(int mealId, int resId, int userId) {
        if (restaurantRepository.getCreatorId(resId).get(0) == userId) {
            return mealRepository.delete(mealId, resId) != 0;
        }
        return false;
    }

    @Override
    public Meal getActualByRestaurant(int resId) {
        LocalDate date = LocalDate.now();
        return mealRepository.getMealByRestaurantIdAndDate(resId, date).orElse(null);
    }

}
