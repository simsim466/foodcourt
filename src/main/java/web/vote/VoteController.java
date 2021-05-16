package web.vote;

import model.Vote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.VoteService;

@RestController
@RequestMapping("/votes")
public class VoteController {
    static final int USER_ID = 10;
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VoteService voteService;

    @DeleteMapping("/delete-current")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete() {
        int id = USER_ID;
        log.info("delete user {} vote", id);
        voteService.delete(id);
    }

    @PutMapping(value = "/vote-for/{mealId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> create(@PathVariable int mealId) {
        Vote vote = Vote.getInstance();
        Vote created = voteService.saveByMeal(vote, mealId, USER_ID);
        return ResponseEntity.ok(created);
    }



}
