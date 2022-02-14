package br.com.lucasromagnoli.dailycalories.domain.usecase.meal;

import br.com.lucasromagnoli.dailycalories.domain.Meal;
import br.com.lucasromagnoli.dailycalories.domain.entities.MealEntity;
import br.com.lucasromagnoli.dailycalories.domain.repository.MealRepository;
import br.com.lucasromagnoli.dailycalories.domain.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveMealUseCase implements UseCase<Meal> {
    public final MealRepository mealRepository;

    @Override
    public Meal handle(Meal meal) {
        var mealEntity = MealEntity.from(meal);
        return Meal.from(mealRepository.save(mealEntity));
    }
}
