package repository.voteImpl;

import model.Vote;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import service.VoteService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class VoteDataJpaTest {
    @Autowired
    private VoteService service;

    @Test
    void save() {
        Vote vote = Vote.getInstance();
        Vote savedEntity = service.save(vote, 1033, 1012);
        System.out.println(savedEntity);
    }

    @Test
    void delete() {
        LocalDate date = LocalDate.of(2021, 5, 11);
        Vote before = service.getByDate(date, 1012);
        service.delete(1012);
        Vote after = service.getByDate(date, 1012);
        System.out.println(after);
    }

    @Test
    void getAllByMealId() {
        List<Vote> votes = service.getAllForMeal(1031);
        System.out.println(votes);
    }

    @Test
    void getAllByDate() {
        LocalDate date = LocalDate.of(2021, 5, 11);
        List<Vote> votes = service.getAllByDate(date);
        System.out.println(votes);
    }

    @Test
    void getByDate() {
        LocalDate date = LocalDate.of(2021, 5, 11);
        Vote vote = service.getByDate(date, 1012);
        System.out.println(vote);
    }

    @Test
    void getVotesNumber() {
        Integer numberOfVotes = service.countVotes(1031);
        System.out.println(numberOfVotes);
    }
}