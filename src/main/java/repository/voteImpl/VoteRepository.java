package repository.voteImpl;

import model.Vote;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository {
    Vote saveByMeal(Vote vote, int mealId, int userId);
    Vote saveByRestaurant(Vote vote, int resId, int userId);
    Boolean deleteToday(int userId);
    //Vote getByDate(LocalDate date, int userId);
    //List<Vote> getAllByMealId(int mealId);
    //List<Vote> getAllByDate(LocalDate date);
    Integer getVotesNumber(int mealId);
    Integer getAllVotesNumber(LocalDate date);
}
