package br.com.lucasromagnoli.dailycalories.rest.controller;

import br.com.lucasromagnoli.dailycalories.domain.Meal;
import br.com.lucasromagnoli.dailycalories.domain.usecase.meal.SaveMealUseCase;
import br.com.lucasromagnoli.dailycalories.rest.dto.MealSave;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/meal")
public class MealController {
    private final SaveMealUseCase saveMealUseCase;

    @PostMapping
    public ResponseEntity<Meal> save(@RequestBody MealSave mealSave) {
        var meal = Meal.from(mealSave);
        return ResponseEntity.ok(meal.save(saveMealUseCase));
    }
}
