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
import util.DateTimeUtil;

import static util.DateTimeUtil.isLateNow;
import static util.DateTimeUtil.today;

@RestController
@RequestMapping(value = "/user/{userId}/meals", produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VoteService voteService;

    @PostMapping(value = "/{mealId}/vote", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> create(@PathVariable int mealId, @PathVariable int userId) {
        log.info("vote for meal {} by user {}", mealId, userId);
        if (isLateNow()) {
            return ResponseEntity.badRequest().build();
        }
        Vote vote = Vote.getInstance();
        Vote created = voteService.save(vote, mealId, userId);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity delete(@PathVariable int userId) {
        log.info("cancel choice by user {}", userId);
        if (isLateNow()) {
            return ResponseEntity.badRequest().build();
        }
        voteService.delete(userId, today());
        return ResponseEntity.noContent().build();
    }
}
