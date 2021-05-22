package model;

import jakarta.validation.constraints.NotNull;
import model.proto.AbstractEntity;
import model.menu.Meal;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import util.DateTimeUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import static util.DateTimeUtil.*;

@Entity
@Table(name = "votes")
@IdClass(VoteId.class)
public class Vote {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Id
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "meal_id", nullable = false)
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Meal meal;

    @Id
    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    public Vote() {
    }

    public Vote(@NotNull LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public static Vote getInstance() {
        return new Vote(today());
    }

    @Override
    public String toString() {
        return "Vote{" +
                "date=" + meal.getDate() +
                " meal=" + meal +
                '}';
    }
}
