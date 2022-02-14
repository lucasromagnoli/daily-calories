package br.com.lucasromagnoli.dailycalories.domain.entities;

import br.com.lucasromagnoli.dailycalories.domain.NutritionalTable;
import br.com.lucasromagnoli.dailycalories.domain.UnityEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Embeddable
public class NutritionalTableEntity {
    private Float protein;
    private Float carbohydrate;
    private Float fat;
    private Float calorie;
    @Enumerated(EnumType.STRING)
    private UnityEnum unity;

    public static NutritionalTableEntity from(NutritionalTable nutritionalTable) {
        var nutritionalTableEntity = new NutritionalTableEntity();
        nutritionalTableEntity.setCarbohydrate(nutritionalTable.getCarbohydrate());
        nutritionalTableEntity.setProtein(nutritionalTable.getProtein());
        nutritionalTableEntity.setCalorie(nutritionalTable.getCalorie());
        nutritionalTableEntity.setFat(nutritionalTable.getFat());
        nutritionalTableEntity.setUnity(nutritionalTable.getUnityEnum());

        return nutritionalTableEntity;
    }
}
