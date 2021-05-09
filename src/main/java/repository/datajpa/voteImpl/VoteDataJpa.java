package repository.datajpa.voteImpl;

import model.Vote;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.VoteRepository;
import repository.datajpa.userImpl.CrudUserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public class VoteDataJpa implements VoteRepository {
    private CrudVoteRepository voteRepository;
    private CrudUserRepository userRepository;

    public VoteDataJpa(CrudVoteRepository voteRepository, CrudUserRepository userRepository) {
        this.voteRepository = voteRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Vote save(Vote vote, int userId) {
        if ( deleteCurrentVote(userId) == null ) {
            return null;
        }
        vote.setUser(userRepository.getById(userId));
        return voteRepository.save(vote);
    }

    @Override//отмена голосования + анекдот про зайца партнера
    @Transactional
    public Boolean deleteCurrentVote(int userId) {
        LocalDateTime dateTime = LocalDateTime.now();
        if (LocalTime.of(11, 0).isBefore(dateTime.toLocalTime())) {
            return null;
        }
        return voteRepository.delete(dateTime.toLocalDate(), userId) != 0;
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
