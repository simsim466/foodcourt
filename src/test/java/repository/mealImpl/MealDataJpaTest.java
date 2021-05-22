package repository.mealImpl;

import model.menu.Dish;
import model.menu.Meal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import service.MealService;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class MealDataJpaTest {
    @Autowired
    private MealService mealService;

    @Test
    void save() {
        Dish dish1 = new Dish("Шницель", 12);
        Dish dish2 = new Dish("Творог", 33);
        List<Dish> dishes = Arrays.asList(dish1, dish2);
        Meal meal = new Meal(dishes, LocalDate.now());
        System.out.println(mealService.create(meal, 1017, 1012));
    }

    /*@Test
    void get() {
        Meal meal = mealService.get(1031);
        meal.getAllDishes().stream().forEach(dish -> System.out.println(dish));
        System.out.println(meal);
    }*/

    @Test
    void getWithRestaurant() {
        Meal meal = mealService.getWithRestaurant(1031, 1017, 1012);
        System.out.println(meal);
    }

    @Test
    void getAllActual() {
        List<Meal> meals = mealService.getAllActual(LocalDate.now());
        System.out.println(meals);
        meals.forEach(m -> System.out.println(m.getRestaurant()));
    }

    @Test
    void delete() {
        //System.out.println(mealService.get(1031));
        mealService.delete(1031, 1017, 1012);
        //System.out.println(mealService.get(1031));
    }


    @Test
    void getActualByRestaurant() {
        Meal meal = mealService.getActualByRestaurant(1015, LocalDate.now());
        System.out.println(meal);
    }

    @Test
    void getAllByRestaurant() {
        List<Meal> meals = mealService.getAllByRestaurant(1015);
        System.out.println(meals);
    }

    @Test
    void getElectionResult() {
        List<Object[]> list = mealService.getElectionResult(LocalDate.now());
        System.out.println(list);
    }
}