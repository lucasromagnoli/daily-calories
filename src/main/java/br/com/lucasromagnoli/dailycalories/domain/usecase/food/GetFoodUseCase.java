package br.com.lucasromagnoli.dailycalories.domain.usecase.food;

import br.com.lucasromagnoli.dailycalories.domain.Food;
import br.com.lucasromagnoli.dailycalories.domain.repository.FoodRepository;
import br.com.lucasromagnoli.dailycalories.domain.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetFoodUseCase implements UseCase<Food> {
    private final FoodRepository foodRepository;

    @Override
    public Food handle(Food food) {
        var foodEntity = foodRepository.findById(food.getId())
                .orElseThrow(() -> new RuntimeException("Food not found"));
        return Food.from(foodEntity);
    }
}
