package repository.voteImpl;

import model.Meal;
import model.User;
import model.Vote;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.mealImpl.CrudMealRepository;
import repository.userImpl.CrudUserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

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
    @Transactional
    public Vote save(Vote vote, int mealId, int userId) {
        LocalDateTime dateTime = LocalDateTime.now();
        if (LocalTime.of(11, 0).isBefore(dateTime.toLocalTime())) {
            return null;
        }
        Meal meal = mealRepository.findById(mealId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        if (meal == null || !meal.getDate().isEqual(dateTime.toLocalDate())) {
            return vote;
        }
        vote.setMeal(meal);
        if (user == null) {
            return vote;
        }
        vote.setUser(user);
        voteRepository.deleteAllByMeal_DateAndUser_Id(dateTime.toLocalDate(), userId);
        return voteRepository.save(vote);
    }

    @Override//отмена голосования
    @Transactional
    public Boolean deleteToday(int userId) {
        LocalDateTime dateTime = LocalDateTime.now();
        if (LocalTime.of(11, 0).isBefore(dateTime.toLocalTime())) {
            return null;
        }
        return voteRepository.deleteAllByMeal_DateAndUser_Id(dateTime.toLocalDate(), userId) != 0;
    }

    @Override
    public List<Vote> getAllByMealId(int mealId) {
        return voteRepository.findByMealId(mealId);
    }

    @Override
    public List<Vote> getAllByDate(LocalDate date) {
        return voteRepository.findVotesByDate(date);
    }

    @Override
    public Vote getByDate(LocalDate date, int userId) {
        return voteRepository.findVoteByDateAndUser(date, userId);
    }

    @Override
    public Integer getVotesNumber(int mealId) {
        return voteRepository.getSumForMeal(mealId);
    }
}
