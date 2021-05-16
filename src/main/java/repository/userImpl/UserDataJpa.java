package repository.userImpl;

import model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDataJpa implements UserRepository {
    private final CrudUserRepository userRepository;

    public UserDataJpa(CrudUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean delete(int userId) {
        return userRepository.delete(userId) != 0;
    }

    @Override
    public User get(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
