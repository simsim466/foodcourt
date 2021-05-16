package repository.userImpl;

import model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    boolean delete(int userId);
    User get(int userId);
    List<User> getAll();

}
