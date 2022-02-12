package br.com.lucasromagnoli.dailycalories.rest.controller;

import br.com.lucasromagnoli.dailycalories.domain.Food;
import br.com.lucasromagnoli.dailycalories.domain.usecase.food.GetFoodUseCase;
import br.com.lucasromagnoli.dailycalories.domain.usecase.food.ListFoodUseCase;
import br.com.lucasromagnoli.dailycalories.domain.usecase.food.SaveFoodUseCase;
import br.com.lucasromagnoli.dailycalories.rest.dto.FoodSave;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodController {
    private final SaveFoodUseCase saveFoodUseCase;
    private final GetFoodUseCase getFoodUseCase;
    private final ListFoodUseCase listFoodUseCase;

    @GetMapping
    public ResponseEntity<List<Food>> list() {
        return ResponseEntity.ok(Food.list(listFoodUseCase));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> get(@PathVariable Long id) {
        return ResponseEntity.ok(Food.get(id, getFoodUseCase));
    }

    @PostMapping
    public ResponseEntity<Food> save(@RequestBody FoodSave foodSave) {
        return ResponseEntity.ok(Food.from(foodSave).save(saveFoodUseCase));
    }
}
