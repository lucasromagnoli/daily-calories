package br.com.lucasromagnoli.dailycalories.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class Meal {
    private LocalTime time;
    private Float quantity;
    private Food food;
}
