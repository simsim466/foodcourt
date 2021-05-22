package web.user;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.UserService;
import to.UserTo;

import java.net.URI;

import static util.UsersUtil.*;
import static util.ValidationUtil.*;

@RestController
@RequestMapping(value = ProfileController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    static final String REST_URL = "/profile";

    @Autowired
    private UserService service;

    @GetMapping("/{userId}")
    public UserTo get(@PathVariable int userId) {
        log.info("get {}", userId);
        return asAuthorizedTo(service.get(userId));
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int userId) {
        log.info("delete user {}", userId);
        service.delete(userId);
    }

    @PostMapping(value = "/register/admin", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> registerAdmin(@RequestBody UserTo userTo) {
        log.info("register as admin {}", userTo);
        checkNew(userTo);
        User created = service.save(createAdminFromTo(userTo));
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL).build().toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
    @PostMapping(value = "/register/user")
    public ResponseEntity<User> registerUser(@RequestBody UserTo userTo) {
        log.info("register {}", userTo);
        checkNew(userTo);
        User created = service.save(createUserFromTo(userTo));
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL).build().toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody UserTo userTo, @PathVariable int userId) {
        log.info("update {}", userTo);
        assureIdConsistent(userTo, userId);
        service.save(convertToUser(userTo));
    }
}
