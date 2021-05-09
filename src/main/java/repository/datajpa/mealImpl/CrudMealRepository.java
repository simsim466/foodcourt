package repository.datajpa.mealImpl;

import model.menu.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {

    @Query("SELECT meal FROM Meal meal JOIN FETCH meal.restaurant" +
            " WHERE meal.id = ?1 AND meal.restaurant.id = ?2 AND meal.restaurant.creator.id = ?3")
    Meal getWithRestaurant(int mealId, int resId, int userId);

    List<Meal> findMealsByDate(LocalDate date);

    @Modifying
    @Transactional
    @Query("DELETE FROM Meal m WHERE m.id =: mealId AND m.restaurant.id =: resId AND m.restaurant.creator.id =: userId")
    int delete (@Param("mealId") int mealId, @Param("resId") int resId, @Param("userId") int userId);

}
