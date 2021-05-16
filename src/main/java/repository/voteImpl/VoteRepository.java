package repository.voteImpl;

import model.Vote;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository {
    Vote save(Vote vote, int mealId, int userId);
    Boolean deleteToday(int userId);
    Vote getByDate(LocalDate date, int userId);
    List<Vote> getAllByMealId(int mealId);
    List<Vote> getAllByDate(LocalDate date);
    Integer getVotesNumber(int mealId);
}
