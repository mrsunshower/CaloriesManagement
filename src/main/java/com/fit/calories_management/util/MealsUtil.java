package com.fit.calories_management.util;

import com.fit.calories_management.model.Meal;
import com.fit.calories_management.model.MealWithExceeded;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.fit.calories_management.model.Meal.*;
import static java.util.stream.Collectors.*;

/**
 * Created by KenTerror on 19.12.2017.
 */
public class MealsUtil {
    public static void main(String[] args) {
        List<MealWithExceeded> filteredMealWithExceed = initAndGetMealsWithExceed();

        filteredMealWithExceed.forEach(System.out::println);
    }

    public static List<MealWithExceeded> initAndGetMealsWithExceed() {
        List<Meal> meals = Arrays.asList(
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Сніданок", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обід", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Вечеря", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Сніданок", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обід", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Вечеря", 510)
        );
        return getFilteredMealWithExceed(meals, LocalTime.MIN, LocalTime.MAX, 2000);
    }

    private static List<MealWithExceeded> getFilteredMealWithExceed(List<Meal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesSumByDate = getCaloriesSumByDate(meals);
        return meals.stream()
                .filter(isBetween(startTime, endTime))
                .map(meal -> new MealWithExceeded(meal, isCaloriesPerDayExceeded(caloriesSumByDate, meal, caloriesPerDay)))
                .collect(toList());
    }

    private static boolean isCaloriesPerDayExceeded(Map<LocalDate, Integer> caloriesSumByDate, Meal meal, int caloriesPerDay) {
        return caloriesSumByDate.getOrDefault(meal.getDate(), 0) > caloriesPerDay;
    }

    private static Map<LocalDate, Integer> getCaloriesSumByDate(List<Meal> meals) {
        return meals.stream()
                .collect(groupingBy(Meal::getDate, summingInt(Meal::getCalories))
                        //Collectors.toMap(Meal::getDate, Meal::getCalories, Integer::sum);
                );
    }
}
