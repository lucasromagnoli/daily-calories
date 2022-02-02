package br.com.lucasromagnoli.dailycalories.rest.controller;

import br.com.lucasromagnoli.dailycalories.domain.entities.Food;
import br.com.lucasromagnoli.dailycalories.domain.usecase.SaveFoodUseCase;
import br.com.lucasromagnoli.dailycalories.rest.dto.FoodSave;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodController {
    private final SaveFoodUseCase saveFoodUseCase;

    @PostMapping
    public ResponseEntity<Food> save(@RequestBody FoodSave foodSave) {
        return ResponseEntity.ok(Food.from(foodSave));
    }
}
