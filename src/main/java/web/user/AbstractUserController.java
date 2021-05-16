package web.user;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.UserService;

import java.util.List;



public abstract class AbstractUserController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService service;

    //валидация есть ли такой юзер
    public User get(int userId)   {
        log.info("get {}", userId);
        return service.get(userId);
    }
    //проверить новый ли
    //создание только через регистрацию
    public User create(User user)   {
        log.info("create {}", user);
        return service.create(user);
    }

    //юзер может менять только сам себя - проверить это
    public void update(User user, int userId)   {
        log.info("update user {} with id = {}", user, userId);
        service.update(user);
    }

    //удалять можно только самого себя - проверить это
    public void delete(int id)  {
        log.info("delete user {}", id);
        service.delete(id);
    }

    public List<User> getAll() {
        log.info("getAll");
        return service.getAll();
    }
}