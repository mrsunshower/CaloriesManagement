package com.logivations.calories_management.model;

/**
 * Created by KenTerror on 19.12.2017.
 */
public class MealWithExceed {
    private Meal meal;
    private boolean isExceed;

    public MealWithExceed(Meal meal, boolean isExceed) {
        this.meal = meal;
        this.isExceed = isExceed;
    }

    @Override
    public String toString() {
        return "MealWithExceed{" +
                "dateTime=" + meal.getDateTime() +
                ", description='" + meal.getDescription() + '\'' +
                ", calories=" + meal.getCalories() +
                ", isExceed=" + isExceed +
                '}';
    }
}
