package model;

public class User extends AbstractNamedEntity {
    private final String password;
    private final Role role;

    public User(int id, String name, String password, Role role) {
        super(id, name);
        this.password = password;
        this.role = role;
    }
}
