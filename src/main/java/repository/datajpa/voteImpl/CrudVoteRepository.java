package repository.datajpa.voteImpl;

import model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository<Vote, Integer> {
    @Query("SELECT v FROM Vote v WHERE v.meal.id =: mealId")
    List<Vote> findByMealId(@Param("mealId") int mealId);

    @Query("SELECT v FROM Vote v WHERE v.meal.date =: date")
    List<Vote> findVotesByDate(LocalDate date);

    @Query("SELECT v FROM Vote v WHERE v.meal.date =: date AND v.user.id =: userId")
    Vote findVoteByDateAndUser(LocalDate date, @Param("userId") int userId);

    @Transactional
    @Query("DELETE FROM Vote v WHERE v.meal.date =: date AND v.user.id =: userId")
    int delete(LocalDate date, int userId);

    @Query("SELECT COUNT (v) FROM Vote v WHERE v.meal.id =: mealId")
    int getSumForMeal(@Param("mealId") int mealId);
}
