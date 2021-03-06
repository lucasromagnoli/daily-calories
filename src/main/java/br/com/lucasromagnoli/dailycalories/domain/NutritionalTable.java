package br.com.lucasromagnoli.dailycalories.domain;

import br.com.lucasromagnoli.dailycalories.domain.entities.NutritionalTableEntity;
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
    private final UnityEnum unityEnum;

    @Builder
    public NutritionalTable(Float protein, Float carbohydrate, Float fat, UnityEnum unityEnum) {
        this.protein = protein;
        this.carbohydrate = carbohydrate;
        this.fat = fat;
        this.unityEnum = unityEnum;
        this.calorie = evalCalories();
    }

    public static NutritionalTable from(NutritionalTableEntity nutritionalTable) {
        return NutritionalTable.builder()
                .protein(nutritionalTable.getProtein())
                .carbohydrate(nutritionalTable.getCarbohydrate())
                .fat(nutritionalTable.getFat())
                .unityEnum(nutritionalTable.getUnity())
                .build();
    }

    private Float evalCalories() {
        var proteinFactor = 4;
        var carbohydrateFactor = 4;
        var fatFactor = 9;

        return (this.protein * proteinFactor) + (this.carbohydrate * carbohydrateFactor) + (this.fat * fatFactor);
    }
}
