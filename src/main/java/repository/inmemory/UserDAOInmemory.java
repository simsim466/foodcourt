package repository.inmemory;

import model.Restaurant;
import model.User;
import repository.UserDAO;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UserDAOInmemory implements UserDAO {
    private final Map<Integer, User> repository = new ConcurrentHashMap<>();
    private final AtomicInteger index = new AtomicInteger(0);


    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User get(int id) {
        return null;
    }
}
