package br.com.lucasromagnoli.dailycalories.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class NutritionalTableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float protein;
    private Float carbohydrate;
    private Float fat;
    private Float calorie;
    @OneToOne(mappedBy = "nutritionalTable")
    private FoodEntity food;
}
