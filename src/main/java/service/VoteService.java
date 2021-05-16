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

    public Vote save(Vote vote, int mealId, int userId) {
        return repository.save(vote, mealId, userId);
    }

    public Vote getByDate(LocalDate date, int userId) {
        return repository.getByDate(date, userId);
    }

    public List<Vote> getAllByDate(LocalDate date) {
        return repository.getAllByDate(date);
    }

    public List<Vote> getAllForMeal(int mealId) {
        return repository.getAllByMealId(mealId);
    }

    public Integer countVotes(int mealId) {
        return repository.getVotesNumber(mealId);
    }

    public void delete(int userId) {
        repository.deleteToday(userId);
    }
}
