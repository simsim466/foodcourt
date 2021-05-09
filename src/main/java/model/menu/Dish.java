package model.menu;

import model.AbstractNamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractNamedEntity {
    @Column(name = "price")
    private double price;

    @ManyToMany(mappedBy = "roles")
    private List<Meal> meals;

    public Dish(int id, String name, double price) {
        super(id, name);
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
                ", meals=" + meals +
                '}';
    }
}
