package com.logivations.calories_management.util;

import com.logivations.calories_management.model.Meal;
import com.logivations.calories_management.model.MealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static com.logivations.calories_management.model.Meal.isBetween;
import static java.util.stream.Collectors.*;

/**
 * Created by KenTerror on 19.12.2017.
 */
public class MealsUtil {
    public static void main(String[] args) {
        List<MealWithExceed> filteredMealWithExceed = initAndGetMealsWithExceed();

        filteredMealWithExceed.forEach(System.out::println);
    }

    public static List<MealWithExceed> initAndGetMealsWithExceed() {
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

    private static List<MealWithExceed> getFilteredMealWithExceed(List<Meal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesSumByDate = getCaloriesSumByDate(meals);
        return meals.stream()
                .filter(isBetween(startTime, endTime))
                .map(meal -> new MealWithExceed(meal, isExceed(caloriesSumByDate, meal, caloriesPerDay)))
                .collect(toList());
    }

    private static boolean isExceed(Map<LocalDate, Integer> caloriesSumByDate, Meal meal, int caloriesPerDay) {
        return caloriesSumByDate.getOrDefault(meal.getDate(), 0) > caloriesPerDay;
    }

    private static Map<LocalDate, Integer> getCaloriesSumByDate(List<Meal> meals) {
        return meals.stream()
                .collect(groupingBy(Meal::getDate, summingInt(Meal::getCalories))
                        //Collectors.toMap(Meal::getDate, Meal::getCalories, Integer::sum);
                );
    }
}
