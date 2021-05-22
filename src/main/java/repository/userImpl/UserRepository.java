package repository.userImpl;

import model.User;

public interface UserRepository {
    User save(User user);
    boolean delete(int userId);
    User get(int userId);
}
