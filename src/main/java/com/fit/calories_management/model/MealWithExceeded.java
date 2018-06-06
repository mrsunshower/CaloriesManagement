package com.fit.calories_management.model;

/**
 * Created by KenTerror on 19.12.2017.
 */
public class MealWithExceeded {
    private final Meal meal;
    private final boolean exceeded;

    public MealWithExceeded(Meal meal, boolean exceeded) {
        this.meal = meal;
        this.exceeded = exceeded;
    }

    @Override
    public String toString() {
        return "MealWithExceed{" +
                "dateTime=" + meal.getDateTime() +
                ", description='" + meal.getDescription() + '\'' +
                ", calories=" + meal.getCalories() +
                ", isExceed=" + exceeded +
                '}';
    }

    public Meal getMeal() {
        return meal;
    }

    public boolean isExceeded() {
        return exceeded;
    }
}
