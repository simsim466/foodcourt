package service;

import model.Vote;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.voteImpl.VoteRepository;
import util.ValidationUtil;

import java.time.LocalDate;
import java.util.List;

import static util.ValidationUtil.*;

@Service
public class VoteService {
    private final VoteRepository repository;

    public VoteService(VoteRepository repository) {
        this.repository = repository;
    }

    public Vote save(Vote vote, int  mealId, int userId) {
        Assert.notNull(vote, "vote must not be null");
        return checkNotFound(repository.save(vote, mealId, userId), "id=" + mealId + "on this day");
    }

    public void delete(int userId, LocalDate date) {
        checkNotFound(repository.delete(userId, date), "id=" + userId + " (user) among votes on " + date);
    }
}
