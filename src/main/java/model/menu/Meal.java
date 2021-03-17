package model.menu;

import model.AbstractEntity;

import java.util.List;

public class Meal extends AbstractEntity {
    private final List<Dish> dishes;

    public Meal(int id, List<Dish> dishes) {
        super(id);
        this.dishes = dishes;
    }

    public List<Dish> getAllDishes() {
        return dishes;
    }

    public double getTotalPrice()   {
        return dishes.stream()
                .mapToDouble(d -> d.getPrice())
                .sum();
    }
}
