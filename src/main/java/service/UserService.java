package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.userImpl.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
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

    public List<User> getAll() {
        return repository.getAll();
    }
}
