package br.com.lucasromagnoli.dailycalories.domain.usecase.food;

import br.com.lucasromagnoli.dailycalories.domain.Food;
import br.com.lucasromagnoli.dailycalories.domain.repository.FoodRepository;
import br.com.lucasromagnoli.dailycalories.domain.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListFoodUseCase implements UseCase<List<Food>> {
    private final FoodRepository foodRepository;

    @Override
    public List<Food> handle() {
        var foodEntities = foodRepository.findAll();
        return Food.from(foodEntities);
    }
}
