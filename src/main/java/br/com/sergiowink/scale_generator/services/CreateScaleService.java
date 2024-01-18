package br.com.sergiowink.scale_generator.services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sergiowink.scale_generator.dtos.scaleRequestDTO;
import br.com.sergiowink.scale_generator.models.Scale;
import br.com.sergiowink.scale_generator.models.ScaleNames;
import br.com.sergiowink.scale_generator.repositories.ScaleNamesRepository;
import br.com.sergiowink.scale_generator.repositories.ScaleRepository;
import br.com.sergiowink.scale_generator.utils.ConvertStringsToDayOfWeek;
import br.com.sergiowink.scale_generator.utils.ExactDays;
import br.com.sergiowink.scale_generator.utils.QuantityNames;
import jakarta.transaction.Transactional;

@Service
public class CreateScaleService {

    @Autowired
    private ScaleRepository scaleRepository;

    @Autowired
    private ScaleNamesRepository scaleNamesRepository;

    @Transactional
    public Scale execute(scaleRequestDTO scale) {
        int year = scale.getYear();
        int monthNumber = scale.getMonth();
        Month month = Month.of(monthNumber);

        YearMonth yearMonth = YearMonth.of(year, month);

        String type = scale.getType().toLowerCase();

        int quantityNames = QuantityNames.getQuantityNames(type);

        List<String> daysOfWeekStrings = scale.getDaysOfWeek();
        List<DayOfWeek> daysOfWeek = ConvertStringsToDayOfWeek.convertStringsToDayOfWeek(daysOfWeekStrings);


        Map<DayOfWeek, List<ScaleNames>> mapDaysNames = new HashMap<>();

        for (DayOfWeek day : daysOfWeek) {
            List<LocalDate> days = ExactDays.getExactDays(yearMonth, day);

            List<String> names = scale.getNames();
            Collections.shuffle(names);

            List<ScaleNames> scaleEntries = new ArrayList<>();
            for (int i = 0; i < days.size(); i++) {
                LocalDate dayCurrent = days.get(i);

                int startIndex = i * quantityNames;
                int endIndex = (i + 1) * quantityNames;

                List<String> namesForDate = new ArrayList<>();

                for (int j = startIndex; j < endIndex; j++) {
                    namesForDate.add(names.get(j % names.size()));
                }

                ScaleNames scaleNames = new ScaleNames(UUID.randomUUID(), dayCurrent, namesForDate);
                scaleEntries.add(scaleNames);
            }

            mapDaysNames.put(day, scaleEntries);
        }

        List<ScaleNames> allScaleEntries = new ArrayList<>();
        for (List<ScaleNames> namesList : mapDaysNames.values()) {
            allScaleEntries.addAll(namesList);
        }

        Scale scaleEntity = Scale.builder()
        .title(scale.getTitle())
        .scaleNames(allScaleEntries)
        .month(monthNumber)
        .year(year)
        .type(scale.getType())
        .build();

        for (ScaleNames scaleNames : allScaleEntries) {
            scaleNamesRepository.save(scaleNames);
        }

        scaleRepository.save(scaleEntity);

        return scaleEntity;
    }


}