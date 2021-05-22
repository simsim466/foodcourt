package repository.userImpl;

import model.Role;
import model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import service.UserService;

import java.util.List;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class UserDataJpaTest {
    @Autowired
    private UserService service;

    @Test
    void save() {
        User user = new User("Дмитрий", "Глуховский");
        user.setRoles(List.of(Role.USER, Role.ADMIN));
        User user2 = service.save(user);
        System.out.println(user2);
    }

    @Test
    void delete() {
        User userAfter = service.get(1000);
        System.out.println(userAfter);
        service.delete(1000);
        User userBefore = service.get(1000);
        System.out.println(userBefore);
    }

    @Test
    void get() {
        User user = service.get(1001);
        System.out.println(user);
    }
}