package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.userImpl.UserRepository;

import static util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository)   {
        this.repository = repository;
    }

    public User get(int userId)   {
        return checkNotFoundWithId(repository.get(userId), userId);
    }

    public User save(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }

    public void delete(int userId)  {
        checkNotFoundWithId(repository.delete(userId), userId);
    }
}
