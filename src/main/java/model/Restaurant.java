package model;

import model.menu.Meal;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Restaurant extends AbstractNamedEntity {
    private Meal current;
    private final Map<LocalDate, Meal> mealHistory = new HashMap<>();
    private final Map<LocalDate, Integer> votingHistory = new HashMap<>();

    public Restaurant(int id, String name) {
        super(id, name);
    }
}
