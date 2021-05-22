package repository.voteImpl;

import model.Vote;

import java.time.LocalDate;

public interface VoteRepository {
    Vote save(Vote vote, int mealId, int userId);
    boolean delete(int userId, LocalDate date);
}
