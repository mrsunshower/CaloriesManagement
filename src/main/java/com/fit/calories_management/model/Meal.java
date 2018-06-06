package com.fit.calories_management.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.function.Predicate;

/**
 * Created by KenTerror on 19.12.2017.
 */
public class Meal {
    private final LocalDateTime dateTime;
    private final String description;
    private final int calories;

    public Meal(LocalDateTime dateTime, String description, int calories) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    private LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    public static Predicate<Meal> isBetween(LocalTime start, LocalTime end) {
        return (meal) -> meal.getTime().compareTo(start) >= 0 &&
                meal.getTime().compareTo(end) <= 0;
    }
}
