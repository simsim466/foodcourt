package service;

import model.menu.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MealRepository;

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

    public List<Meal> getAllActual() {
        return mealRepository.getAllActual();
    }
    /*//проверить входные данные на null
    public Meal create(Meal meal, int userId)   {
        return mealRepository.save(meal, userId);
    }
    //проверить входные данные на null
    public Meal update(Meal meal, int userId)   {
        return mealRepository.save(meal, userId);
    }
    //проверить результат удалось ли найти
    public void delete(int mealId, int userId)  {
        mealRepository.delete(mealId, userId);
    }
    //проверить результат удалось ли найти
    public void vote(int mealId, int userId)    {
        mealRepository.vote(mealId, userId);
    }
    */
}
