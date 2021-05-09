package web;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.UserService;


//@Controller
public class UserController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

   // @Autowired
    private UserService service;

    //валидация есть ли такой ресторан
    public User get()   {
        int userId = 0;
        log.info("get user {}", userId);
        return service.get(userId);
    }
    //проверить новый ли
    //создание только через регистрацию
    public User create(User user)   {
        log.info("create {}", user);
        return service.create(user);
    }

    //юзер может менять только сам себя - проверить это
    public User update(User user)   {
        int userId = 0;
        log.info("update {}", user);
        return service.update(user);
    }

    //удалять можно только самого себя - проверить это
    public void delete(int id)  {
        int userId = 0;
        log.info("delete user {}", id);
        service.delete(id);
    }



}