package br.com.lucasromagnoli.dailycalories.domain.entities;

import br.com.lucasromagnoli.dailycalories.domain.Food;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "food")
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private NutritionalTableEntity nutritionalTable;

    public static FoodEntity from(Food food) {
        var foodEntity = new FoodEntity();
        var nutritionalTableEntity = NutritionalTableEntity.from(food.getNutritionalTable());
        foodEntity.setId(food.getId());
        foodEntity.setName(food.getName());
        foodEntity.setNutritionalTable(nutritionalTableEntity);
        return foodEntity;
    }
}
