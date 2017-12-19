package com.logivations.calories_management.util;

import com.logivations.calories_management.model.Meal;
import com.logivations.calories_management.model.MealWithExceed;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

/**
 * Created by KenTerror on 19.12.2017.
 */
public class MealsUtil {
    public static void main(String[] args) {
        List<Meal> meals = Arrays.asList(
                new Meal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Сніданок", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обід", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Вечеря", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Сніданок", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обід", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Вечеря", 510)
        );
        List<MealWithExceed> filteredMealWithExceed = getFilteredMealWithExceed(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);

        filteredMealWithExceed.forEach(System.out::println);
    }

    private static List<MealWithExceed> getFilteredMealWithExceed(List<Meal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        return null;
    }

}
