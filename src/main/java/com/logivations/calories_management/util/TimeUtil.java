package com.logivations.calories_management.util;

import java.time.LocalTime;

/**
 * Created by KenTerror on 19.12.2017.
 */
public class TimeUtil {
    public static boolean isBetween(LocalTime localTime, LocalTime startTime, LocalTime endTime) {
        return localTime.compareTo(startTime) >= 0 &&
                localTime.compareTo(endTime) <= 0;
    }
}