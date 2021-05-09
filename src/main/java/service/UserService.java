package service;

import model.User;
import org.springframework.stereotype.Service;
import repository.UserRepository;

//@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository)   {
        this.repository = repository;
    }

    //проверить результат удалось ли найти
    public User get(int id)   {
        return repository.get(id);
    }

    //проверить входные на null
    public User create(User user) {
        return repository.save(user);
    }
    //проверить входные на null
    public User update(User user)   {
        return repository.save(user);
    }

    //проверить результат удалось ли найти
    public void delete(int userId)  {
        repository.delete(userId);
    }

}
