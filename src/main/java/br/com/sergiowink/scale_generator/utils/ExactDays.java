package br.com.sergiowink.scale_generator.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class ExactDays {

    public static List<LocalDate> getExactDays(YearMonth yearMonth, DayOfWeek dayOfWeek) {
        LocalDate startDate = yearMonth.atDay(1);
        LocalDate lastDayOfTheMonth = yearMonth.atEndOfMonth();

        List<LocalDate> diasExatos = new ArrayList<>();

        while (!startDate.isAfter(lastDayOfTheMonth)) {
            if (startDate.getDayOfWeek() == dayOfWeek) {
                diasExatos.add(startDate);
            }
            startDate = startDate.plusDays(1);
        }

        return diasExatos;
    }
}
