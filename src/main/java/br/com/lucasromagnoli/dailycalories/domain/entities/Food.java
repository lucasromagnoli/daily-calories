package br.com.lucasromagnoli.dailycalories.domain.entities;

import br.com.lucasromagnoli.dailycalories.domain.usecase.SaveFoodUseCase;
import br.com.lucasromagnoli.dailycalories.rest.dto.FoodSave;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Food {
    private String name;
    private final NutritionalTable nutritionalTable;

    public static Food from(FoodSave foodSave) {
        return Food.builder()
                .name(foodSave.getName())
                .nutritionalTable(NutritionalTable.builder()
                        .protein(foodSave.getProtein())
                        .carbohydrate(foodSave.getCarbohydrate())
                        .fat(foodSave.getFat())
                        .build())
                .build();
    }

    public Food save(SaveFoodUseCase saveFoodUseCase) {
        return saveFoodUseCase.handle(this);
    }
}
