package util;

import model.Role;
import model.User;
import to.UserTo;

import java.util.Arrays;

public class UsersUtil {
    //для всех пользователей
    public static UserTo asTo(User user) {
        return new UserTo(user.getId(), user.getName());
    }
    //для самого пользователя
    public static UserTo asAuthorizedTo(User user) {
        return new UserTo(user.getId(), user.getName())
                .setPasswordAndReturn(user.getPassword());
    }

    public static User createAdminFromTo(UserTo userTo) {
        User user = convertToUser(userTo);
        user.setRoles(Arrays.asList(Role.ADMIN, Role.USER));
        return user;
    }

    public static User createUserFromTo(UserTo userTo) {
        User user = convertToUser(userTo);
        user.setRoles(Arrays.asList(Role.USER));
        return user;
    }

    public static User convertToUser(UserTo userTo) {
        User user = new User();
        user.setId(userTo.getId());
        user.setName(userTo.getName());
        user.setPassword(userTo.getPassword());
        return user;
    }

    private UsersUtil() {
    }
}
