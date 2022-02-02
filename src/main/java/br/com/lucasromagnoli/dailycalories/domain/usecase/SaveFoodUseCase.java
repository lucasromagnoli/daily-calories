package br.com.lucasromagnoli.dailycalories.domain.usecase;

import br.com.lucasromagnoli.dailycalories.domain.entities.Food;
import org.springframework.stereotype.Service;

@Service
public class SaveFoodUseCase implements UseCase<Food> {
    public Food handle(Food food) {
        return food;
    }
}
