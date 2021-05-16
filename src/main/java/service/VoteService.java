package service;

import model.Vote;
import org.springframework.stereotype.Service;
import repository.voteImpl.VoteRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class VoteService {
    private final VoteRepository repository;

    public VoteService(VoteRepository repository) {
        this.repository = repository;
    }

    public Vote saveByMeal(Vote vote, int mealId, int userId) {
        return repository.saveByMeal(vote, mealId, userId);
    }

    public Vote saveByRestaurant(Vote vote, int resId, int userId) {
        return repository.saveByRestaurant(vote, resId, userId);
    }

    public Integer countAllVotes(LocalDate date) {
        return repository.getAllVotesNumber(date);
    }

    public Integer countVotes(int mealId) {
        return repository.getVotesNumber(mealId);
    }

    public void delete(int userId) {
        repository.deleteToday(userId);
    }
}
