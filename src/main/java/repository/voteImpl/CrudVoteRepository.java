package repository.voteImpl;

import model.Vote;
import model.VoteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository<Vote, VoteId> {

    @Transactional
    @Query("DELETE FROM Vote v WHERE v.date =:date")
    int delete(/*@Param("userId") int userId, */@Param("date") LocalDate date);
}
