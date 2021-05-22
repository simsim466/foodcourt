package to;

import to.protoTo.BaseNamedTo;

public class UserTo extends BaseNamedTo {
    private String password;

    //без пароля для всех остальных - в контроллерах ресторана
    public UserTo(Integer id, String name) {
        super(id, name);
    }

    //для самого авторизованного пользователя
    public UserTo setPasswordAndReturn(String password) {
        this.password = password;
        return this;
    }

    public String getPassword() {
        return password;
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
