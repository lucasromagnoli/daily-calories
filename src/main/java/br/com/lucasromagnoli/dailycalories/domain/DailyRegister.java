package br.com.lucasromagnoli.dailycalories.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class DailyRegister {
    private LocalDate date;
    private List<Meal> meals;
}
