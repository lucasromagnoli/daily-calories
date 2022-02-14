package br.com.lucasromagnoli.dailycalories.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class MealSave {
    private LocalTime time;
    private Float quantity;
    @JsonProperty("food_id")
    private Long foodId;
    @JsonProperty("daily_register_id")
    private Long dailyRegisterId;
}
