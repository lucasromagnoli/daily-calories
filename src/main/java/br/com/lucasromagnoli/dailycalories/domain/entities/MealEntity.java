package br.com.lucasromagnoli.dailycalories.domain.entities;

import br.com.lucasromagnoli.dailycalories.domain.Meal;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "meal")
public class MealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime time;
    private Float quantity;
    @OneToOne
    private FoodEntity food;
    @ManyToOne
    private DailyRegisterEntity dailyRegister;

    public static MealEntity from(Meal meal) {
        var foodEntity = new FoodEntity();
        foodEntity.setId(meal.getFood().getId());

        var dailyRegisterEntity = new DailyRegisterEntity();
        dailyRegisterEntity.setId(meal.getDailyRegisterId());

        var mealEntity = new MealEntity();
        mealEntity.setTime(meal.getTime());
        mealEntity.setQuantity(meal.getQuantity());
        mealEntity.setFood(foodEntity);
        mealEntity.setDailyRegister(dailyRegisterEntity);
        return mealEntity;
    }
}
