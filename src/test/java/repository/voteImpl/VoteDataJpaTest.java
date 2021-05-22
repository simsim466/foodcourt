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
        Vote vote = new Vote(LocalDate.now());
        Vote response = service.save(vote, 1033, 1013);
        System.out.println(response.getUser());
    }

    @Test
    void delete() {
        //System.out.println(service.get(1011));
        service.delete(1011, LocalDate.now());
        //System.out.println(service.get(1011));
    }

}