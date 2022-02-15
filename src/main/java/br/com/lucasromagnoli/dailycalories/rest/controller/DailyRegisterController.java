package br.com.lucasromagnoli.dailycalories.rest.controller;

import br.com.lucasromagnoli.dailycalories.domain.DailyRegister;
import br.com.lucasromagnoli.dailycalories.domain.usecase.register.ListDailyRegisterUseCase;
import br.com.lucasromagnoli.dailycalories.domain.usecase.register.SaveDailyRegisterUseCase;
import br.com.lucasromagnoli.dailycalories.rest.dto.DailyRegisterSave;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/daily_register")
public class DailyRegisterController {
    private final SaveDailyRegisterUseCase saveDailyRegisterUseCase;
    private final ListDailyRegisterUseCase listDailyRegisterUseCase;

    @GetMapping
    public ResponseEntity<List<DailyRegister>> list() {
        return ResponseEntity.ok(DailyRegister.list(listDailyRegisterUseCase));
    }

    @PostMapping
    public ResponseEntity<DailyRegister> save(@RequestBody DailyRegisterSave dailyRegisterSave) {
        var dailyRegister = DailyRegister.from(dailyRegisterSave);
        return ResponseEntity.ok(dailyRegister.save(saveDailyRegisterUseCase));
    }
}
