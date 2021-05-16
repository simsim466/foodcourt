package model;

import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "votes")
public class Vote extends AbstractEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "meal_id", nullable = false)
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Meal meal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Vote(Integer id, @NotNull Meal meal, @NotNull User user) {
        super(id);
        this.meal = meal;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vote() {
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public static Vote getInstance() {
        return new Vote();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(Hibernate.getClass(o))) {
            return false;
        }
        Vote that = (Vote) o;
        return this.user.equals(that.user)
                && this.meal.getDate().isEqual(that.meal.getDate());
    }

    @Override
    public int hashCode() {
        return user == null ? 0 : user.getId();
    }

    @Override
    public String toString() {
        return "Vote{" +
                "date=" + meal.getDate() +
                " meal=" + meal +
                '}';
    }
}
