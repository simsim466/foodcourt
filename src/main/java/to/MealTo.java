package to;

import model.menu.Dish;
import to.protoTo.BaseTo;

import java.time.LocalDate;
import java.util.List;

public class MealTo extends BaseTo {
    private List<Dish> dishes;
    private LocalDate date;
    private RestaurantTo restaurant;
    private Integer votesNumber;
    //is the entity able to be voted for
    private Boolean isCurrent;

    public MealTo(Integer id, List<Dish> dishes, LocalDate date) {
        super(id);
        this.dishes = dishes;
        this.date = date;
    }

    public MealTo(Integer id, List<Dish> dishes, LocalDate date, RestaurantTo restaurant) {
        super(id);
        this.dishes = dishes;
        this.date = date;
        this.restaurant = restaurant;
    }

    public MealTo(Integer id, List<Dish> dishes, LocalDate date, RestaurantTo restaurant, Integer votesNumber) {
        super(id);
        this.dishes = dishes;
        this.date = date;
        this.restaurant = restaurant;
        this.votesNumber = votesNumber;
    }

    public MealTo(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public RestaurantTo getRestaurant() {
        return restaurant;
    }

    public void setVotesNumber(Integer votesNumber) {
        this.votesNumber = votesNumber;
    }

    public void setRestaurant(RestaurantTo restaurant) {
        this.restaurant = restaurant;
    }

    public Boolean getCurrent() {
        return isCurrent;
    }

    public void setCurrent(Boolean current) {
        isCurrent = current;
    }

    public double getTotalPrice()   {
        return dishes.stream()
                .mapToDouble(d -> d.getPrice())
                .sum();
    }

    @Override
    public String toString() {
        return "MealTo{" +
                "dishes=" + dishes +
                ", date=" + date +
                ", restaurant=" + restaurant +
                ", votesNumber=" + votesNumber +
                ", id=" + id +
                '}';
    }
}
