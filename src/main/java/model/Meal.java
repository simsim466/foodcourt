package model;

import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "meals", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id", "date"}, name = "meals_unique_idx")})
public class Meal extends AbstractEntity {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "meals_dishes", joinColumns = @JoinColumn(name = "meal_id"), inverseJoinColumns = @JoinColumn(name = "dish_id"))
    @NotNull
    private List<Dish> dishes;

    @Column(name = "date", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Restaurant restaurant;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "votes", joinColumns = {@JoinColumn(name = "meal_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private List<Vote> votes;

    public Meal(int id, List<Dish> dishes, Restaurant restaurant) {
        super(id);
        this.dishes = dishes;
        this.restaurant = restaurant;
    }

    public Meal() {
    }

    public void setDishes(List<Dish> dishes)    {
        this.dishes = dishes;
    }

    public List<Dish> getAllDishes() {
        return dishes;
    }

    public void setRestaurant(Restaurant restaurant)    {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public double getTotalPrice()   {
        return dishes.stream()
                .mapToDouble(d -> d.getPrice())
                .sum();
    }
}
