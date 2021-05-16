package repository.mealImpl;

import model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {

    @Query("SELECT meal FROM Meal meal " +
            "LEFT JOIN FETCH meal.restaurant" +
            " WHERE meal.id = ?1 AND meal.restaurant.id = ?2" +
            " AND meal.restaurant.creator.id = ?3")
    Optional<Meal> getWithRestaurant(int mealId, int resId, int userId);

    Optional<Meal> getMealByRestaurantIdAndDate(int resId, LocalDate date);

    List<Meal> findMealsByDate(LocalDate date);

    @Modifying
    @Transactional
    @Query("DELETE FROM Meal m WHERE m.id =:mealId AND m.restaurant.id =:resId")
    int delete (@Param("mealId")int mealId, @Param("resId")int resId);

    boolean existsMealByDateAndRestaurantId(LocalDate date, int resId);

}
