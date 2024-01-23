package br.com.sergiowink.scale_generator.dtos;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class scaleRequestDTO {
    
    private String title;
 
    private ArrayList<String> names;

    private ArrayList<String> daysOfWeek;

    private int month;

    private int year;

    private String type;
}
