package br.com.lucasromagnoli.dailycalories.domain;

import br.com.lucasromagnoli.dailycalories.domain.entities.MealEntity;
import br.com.lucasromagnoli.dailycalories.domain.usecase.meal.SaveMealUseCase;
import br.com.lucasromagnoli.dailycalories.rest.dto.MealSave;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Builder
public class Meal {
    private LocalTime time;
    private Float quantity;
    private Food food;
    private Long dailyRegisterId;

    public static Meal from(MealEntity mealEntity) {
        return Meal.builder()
                .time(mealEntity.getTime())
                .quantity(mealEntity.getQuantity())
                .food(Food.from(mealEntity.getFood()))
                .dailyRegisterId(mealEntity.getDailyRegister().getId())
                .build();
    }

    public static Meal from(MealSave mealSave) {
        return Meal.builder()
                .time(mealSave.getTime())
                .quantity(mealSave.getQuantity())
                .food(Food.builder()
                        .id(mealSave.getFoodId())
                        .build())
                .dailyRegisterId(mealSave.getDailyRegisterId())
                .build();
    }

    public Meal save(SaveMealUseCase saveMealUseCase) {
        return saveMealUseCase.handle(this);
    }
}
