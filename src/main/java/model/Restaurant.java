package model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "restaurants_unique_idx")})
public class Restaurant extends AbstractNamedEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_user_id", nullable = false)
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User creator;

    public Restaurant(int id, String name, User user) {
        super(id, name);
        this.creator = user;
    }

    public Restaurant() {
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User user)   {
        creator = user;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name=" + name +
                ", creator=" + creator +
                '}';
    }
}
