package repository;

import model.User;

import java.util.List;

public interface UserDAO {
    User save(User user);
    boolean delete(int id);
    List<User> getAll();
    User get(int id);
}
