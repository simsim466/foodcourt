package model.menu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import model.proto.AbstractNamedEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractNamedEntity {
    @Column(name = "price")
    private double price;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "dishes", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Meal> meals;

    public Dish(int id, String name, double price) {
        super(id, name);
        this.price = price;
    }

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Dish() {
    }

    public double getPrice() {
        return price;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


}
