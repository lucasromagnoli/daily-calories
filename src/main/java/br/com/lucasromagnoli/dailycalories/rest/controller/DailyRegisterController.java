package br.com.lucasromagnoli.dailycalories.rest.controller;

import br.com.lucasromagnoli.dailycalories.domain.DailyRegister;
import br.com.lucasromagnoli.dailycalories.domain.usecase.register.SaveDailyRegisterUseCase;
import br.com.lucasromagnoli.dailycalories.rest.dto.DailyRegisterSave;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/daily_register")
public class DailyRegisterController {
    private final SaveDailyRegisterUseCase saveDailyRegisterUseCase;

    @PostMapping
    public ResponseEntity<DailyRegister> save(@RequestBody DailyRegisterSave dailyRegisterSave) {
        var dailyRegister = DailyRegister.from(dailyRegisterSave);
        return ResponseEntity.ok(dailyRegister.save(saveDailyRegisterUseCase));
    }
}
