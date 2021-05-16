package service;

import model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.mealImpl.MealRepository;

import java.util.List;

@Service
public class MealService {
    private final MealRepository mealRepository;
    @Autowired
    public MealService(MealRepository mealRepository)   {
        this.mealRepository = mealRepository;
    }

    //проверить результат удалось ли найти
    public Meal get(int mealId)  {
        return mealRepository.get(mealId);
    }

    public Meal getWithRestaurant(int mealId, int resId, int userId) {
        return mealRepository.getWithRestaurant(mealId, resId, userId);
    }

    public Meal getActualByRestaurant(int resId) {
        return mealRepository.getActualByRestaurant(resId);
    }

    public List<Meal> getAllActual() {
        return mealRepository.getAllActual();
    }

    public void delete(int mealId, int resId, int userId) {
        mealRepository.delete(mealId, resId, userId);
    }

    public Meal create(Meal meal, int resId, int userId) {
        return mealRepository.save(meal, userId, resId);
    }

}
