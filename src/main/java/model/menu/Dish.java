package model.menu;

import model.AbstractNamedEntity;

public class Dish extends AbstractNamedEntity {
    private double price;

    public Dish(int id, String name, double price) {
        super(id, name);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
