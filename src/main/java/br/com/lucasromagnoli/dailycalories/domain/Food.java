package br.com.lucasromagnoli.dailycalories.domain;

import br.com.lucasromagnoli.dailycalories.domain.entities.FoodEntity;
import br.com.lucasromagnoli.dailycalories.domain.usecase.food.GetFoodUseCase;
import br.com.lucasromagnoli.dailycalories.domain.usecase.food.ListFoodUseCase;
import br.com.lucasromagnoli.dailycalories.domain.usecase.food.SaveFoodUseCase;
import br.com.lucasromagnoli.dailycalories.rest.dto.FoodSave;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class Food {
    private Long id;
    private String name;
    private final NutritionalTable nutritionalTable;

    public static List<Food> from(List<FoodEntity> foodEntities) {
        return foodEntities.stream().map(Food::from).collect(Collectors.toList());
    }

    public static Food from(FoodEntity foodEntity) {
        return Food.builder()
                .id(foodEntity.getId())
                .name(foodEntity.getName())
                .nutritionalTable(NutritionalTable.from(foodEntity.getNutritionalTable()))
                .build();
    }

    public static Food from(FoodSave foodSave) {
        return Food.builder()
                .name(foodSave.getName())
                .nutritionalTable(NutritionalTable.builder()
                        .protein(foodSave.getProtein())
                        .carbohydrate(foodSave.getCarbohydrate())
                        .fat(foodSave.getFat())
                        .unityEnum(Optional.ofNullable(UnityEnum.getByAbbreviationOrCode(foodSave.getUnity()))
                                .orElseThrow(() -> new RuntimeException("Unity not found.")))
                        .build())
                .build();
    }

    public static List<Food> list(ListFoodUseCase listFoodUseCase) {
        return  listFoodUseCase.handle();
    }

    public static Food get(Long id, GetFoodUseCase getFoodUseCase) {
        return getFoodUseCase.handle(Food.builder()
                .id(id)
                .build());
    }

    public Food save(SaveFoodUseCase saveFoodUseCase) {
        return saveFoodUseCase.handle(this);
    }
}
