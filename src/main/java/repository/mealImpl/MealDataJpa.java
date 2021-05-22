package repository.mealImpl;

import model.menu.Meal;

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
        if ( !restaurantRepository.existsByIdAndCreator_Id(resId, userId)) {
            return meal;
        }
        if (!meal.isNew() && !mealRepository.existsMealByIdAndRestaurant_Id(meal.id(), resId)) {
            return null;
        }
        if (meal.isNew() && mealRepository.existsMealByDateAndRestaurantId(meal.getDate(), resId)) {
            return null;
        }
        meal.setRestaurant(restaurantRepository.getById(resId));
        return mealRepository.save(meal);
    }

    @Override
    public Meal getWithRestaurant(int mealId, int resId, int userId) {
        return mealRepository.getWithRestaurant(mealId, resId, userId).orElse(null);
    }

    @Override
    //посмотреть список всех ед но с указанием ресторана - объединить с верхним - done
    public List<Meal> getAllActual(LocalDate date) {
        return mealRepository.getAllActualWithRestaurant(date);
    }

    @Override
    //удалить еду своего ресторана - done
    public Boolean delete(int mealId, int resId, int userId) {
        if (restaurantRepository.existsByIdAndCreator_Id(resId, userId)) {
            return mealRepository.delete(mealId, resId) != 0;
        }
        return null;
    }

    @Override
    //юзер нажимает на ресторан посмотреть текущую еду еду - done
    public Meal getActualByRestaurant(int resId, LocalDate date) {
        return mealRepository.getMealByRestaurantIdAndDate(resId, date).orElse(null);
    }

    //должно быть посмотреть историю еды для рестрана - брат того что выше - done
    @Override
    public List<Meal> getAllByRestaurant(int resId) {
        return mealRepository.findMealsByRestaurant_IdOrderByDateDesc(resId);
    }


    //посмотреть итоги голосования дня - тоже самое только с рейтингом - НЕ СДЕЛАНО
    @Override
    public List<Object[]> getElectionResult(LocalDate date) {
        return mealRepository.getMealWithVotesCount(date);
    }
}
