package br.com.sergiowink.scale_generator.utils;

import java.time.DayOfWeek;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertStringsToDayOfWeek {
    public static List<DayOfWeek> convertStringsToDayOfWeek(List<String> daysOfWeekStrings) {
        return daysOfWeekStrings.stream()
                .map(dayString -> DayOfWeek.valueOf(dayString.toUpperCase()))
                .collect(Collectors.toList());
    }
}
