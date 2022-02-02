package br.com.lucasromagnoli.dailycalories.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NutritionalTable {
    private final Float protein;
    private final Float carbohydrate;
    private final Float fat;
    private final Float calorie;

    @Builder
    public NutritionalTable(Float protein, Float carbohydrate, Float fat) {
        this.protein = protein;
        this.carbohydrate = carbohydrate;
        this.fat = fat;
        this.calorie = evalCalories();
    }

    private Float evalCalories() {
        var proteinFactor = 4;
        var carbohydrateFactor = 4;
        var fatFactor = 9;

        return (this.protein * proteinFactor) + (this.carbohydrate * carbohydrateFactor) + (this.fat * fatFactor);
    }
}
