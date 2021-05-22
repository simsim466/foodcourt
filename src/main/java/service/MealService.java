package service;

import model.menu.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.mealImpl.MealRepository;

import java.time.LocalDate;
import java.util.List;

import static util.ValidationUtil.*;

@Service
public class MealService {
    private final MealRepository mealRepository;

    @Autowired
    public MealService(MealRepository mealRepository)   {
        this.mealRepository = mealRepository;
    }

    public Meal getWithRestaurant(int mealId, int resId, int userId) {
        return mealRepository.getWithRestaurant(mealId, resId, userId);
    }

    public List<Meal> getAllByRestaurant(int resId) {
        return mealRepository.getAllByRestaurant(resId);
    }
    //done
    public Meal getActualByRestaurant(int resId, LocalDate date) {
        Assert.notNull(date, "date must not be null");
        return checkNotFound(mealRepository.getActualByRestaurant(resId, date),
                "with id=" + resId + " on " + date);
    }
    //done
    public List<Meal> getAllActual(LocalDate date) {
        Assert.notNull(date, "date must not be null");
        return mealRepository.getAllActual(date);
    }
    //done
    public void delete(int mealId, int resId, int userId) {
        Boolean result = mealRepository.delete(mealId, resId, userId);
        checkNotFound(result, "id=" + resId + " with creator with id=" + userId);
        checkNotFoundWithId((boolean) result, mealId);
    }
    //done но... код не очень
    public Meal create(Meal meal, int resId, int userId) {
        Assert.notNull(meal, "meal must not be null");
        Meal result = mealRepository.save(meal, userId, resId);
        if (result == null) {
            StringBuilder stb = new StringBuilder("");
            if (meal.isNew()) {
                stb.append("restaurant (id=" + resId + ") on " + meal.getDate()
                        + "to save due to the presence of another entity");
            }
            else {
                stb.append("id=" + result.getId());
            }
            checkNotFound(false, stb.toString());
        }
        checkNotFound(result.getRestaurant() != null, "id=" + resId
                + " (restaurant) for user with id=" + userId);
        return result;
    }

    public List<Object[]> getElectionResult(LocalDate date) {
        return mealRepository.getElectionResult(date);
    }
}
