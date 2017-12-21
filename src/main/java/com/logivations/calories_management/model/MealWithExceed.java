package com.logivations.calories_management.model;

/**
 * Created by KenTerror on 19.12.2017.
 */
public class MealWithExceed {
    private final Meal meal;
    private final boolean exceed;

    public MealWithExceed(Meal meal, boolean exceed) {
        this.meal = meal;
        this.exceed = exceed;
    }

    @Override
    public String toString() {
        return "MealWithExceed{" +
                "dateTime=" + meal.getDateTime() +
                ", description='" + meal.getDescription() + '\'' +
                ", calories=" + meal.getCalories() +
                ", isExceed=" + exceed +
                '}';
    }

    public Meal getMeal() {
        return meal;
    }

    public boolean isExceed() {
        return exceed;
    }
}
