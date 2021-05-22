package to;

import to.protoTo.BaseNamedTo;

public class RestaurantTo extends BaseNamedTo {
    private UserTo creator;
    //current meal of the restaurant
    private MealTo mealTo;
    //true - for admin who has uploaded the restaurant; false - for all
    private Boolean enable;

    //для подачи на фронтенд
    public RestaurantTo(Integer id, String name, boolean enable) {
        super(id, name);
        this.enable = enable;
    }

    public RestaurantTo(String name) {
        this.name = name;
    }

    //для приема с фронтенда
    public RestaurantTo(Integer id, String name) {
        super(id, name);
    }

    public void setCreator(UserTo creator) {
        this.creator = creator;
    }

    public void setMealTo(MealTo mealTo) {
        this.mealTo = mealTo;
    }

    @Override
    public String toString() {
        String min = "RestaurantTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enable=" + enable;
        StringBuilder stb = new StringBuilder(min);
        if (creator != null) {
            stb.append(", creator=" + creator);
        }
        if (mealTo != null) {
            stb.append(", meal=" + mealTo);
        }
        stb.append('}');
        return stb.toString();
    }
}
