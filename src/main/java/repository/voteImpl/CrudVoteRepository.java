package repository.voteImpl;

import model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository<Vote, Integer> {
    @Query("SELECT v FROM Vote v WHERE v.meal.id = :mealId")
    List<Vote> findByMealId(@Param("mealId") int mealId);

    @Query("SELECT v FROM Vote v WHERE v.meal.date = :date")
    List<Vote> findVotesByDate(@Param("date") LocalDate date);

    @Query("SELECT v FROM Vote v WHERE v.meal.date = :date AND v.user.id = :userId")
    Vote findVoteByDateAndUser(@Param("date") LocalDate date, @Param("userId") int userId);

    @Transactional
    @Query("DELETE FROM Vote v WHERE v.meal.date = :date" +
            " AND v.user.id = :userId")
    int delete(@Param("date") LocalDate date, @Param("userId") int userId);

    @Query("SELECT COUNT (v) FROM Vote v WHERE v.meal.id = :mealId")
    int getSumForMeal(@Param("mealId") int mealId);

    @Query("SELECT COUNT (v) FROM Vote v JOIN v.meal WHERE v.meal.date = :date")
    int getAllSumByDate(@Param("date") LocalDate date);

    int deleteAllByMeal_DateAndUser_Id(LocalDate date, int userId);
}
