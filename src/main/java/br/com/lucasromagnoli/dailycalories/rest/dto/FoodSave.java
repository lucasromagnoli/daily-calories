package br.com.lucasromagnoli.dailycalories.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodSave {
    private String name;
    private Float calorie;
    private Float fat;
    private Float protein;
    private Float carbohydrate;
    private String unity;
}
