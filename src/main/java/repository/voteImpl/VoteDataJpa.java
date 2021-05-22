package repository.voteImpl;

import model.User;
import model.Vote;
import model.VoteId;
import model.menu.Meal;
import org.springframework.stereotype.Repository;
import repository.mealImpl.CrudMealRepository;
import repository.userImpl.CrudUserRepository;

import java.time.LocalDate;

import static util.DateTimeUtil.isToday;

@Repository
public class VoteDataJpa implements VoteRepository {
    private final CrudVoteRepository voteRepository;
    private final CrudUserRepository userRepository;
    private final CrudMealRepository mealRepository;

    public VoteDataJpa(CrudVoteRepository voteRepository,
                       CrudUserRepository userRepository, CrudMealRepository mealRepository) {
        this.voteRepository = voteRepository;
        this.userRepository = userRepository;
        this.mealRepository = mealRepository;
    }

    @Override
    public Vote save(Vote vote, int mealId, int userId) {
        Meal meal = mealRepository.getById(mealId);
        if (!isToday(meal.getDate())) {
            return null;
        }
        User user = userRepository.getById(userId);
        vote.setMeal(meal);
        vote.setUser(user);
        return voteRepository.save(vote);
    }

    @Override
    public boolean delete(int userId, LocalDate date) {
        if (!voteRepository.existsById(new VoteId(userId, date))) {
            return false;
        }
        voteRepository.deleteById(new VoteId(userId, date));
        return true;
    }
}
