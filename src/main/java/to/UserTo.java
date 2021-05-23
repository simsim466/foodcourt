package to;

import to.protoTo.BaseNamedTo;

public class UserTo extends BaseNamedTo {
    private String password;

    //без пароля для всех остальных - в контроллерах ресторана
    public UserTo(Integer id, String name) {
        super(id, name);
    }

    public UserTo() {}

    public UserTo(String name, String password) {
        this.name = name;
        this.password = password;
    }

    //для самого авторизованного пользователя
    public UserTo setPasswordAndReturn(String password) {
        this.password = password;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
