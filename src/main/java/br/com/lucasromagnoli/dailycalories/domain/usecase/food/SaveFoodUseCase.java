package br.com.lucasromagnoli.dailycalories.domain.usecase.food;

import br.com.lucasromagnoli.dailycalories.domain.Food;
import br.com.lucasromagnoli.dailycalories.domain.entities.FoodEntity;
import br.com.lucasromagnoli.dailycalories.domain.repository.FoodRepository;
import br.com.lucasromagnoli.dailycalories.domain.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveFoodUseCase implements UseCase<Food> {
    private final FoodRepository foodRepository;

    public Food handle(Food food) {
        var foodEntity = foodRepository.save(FoodEntity.from(food));
        return Food.from(foodEntity);
    }
}
