package br.com.lucasromagnoli.dailycalories.domain.usecase.register;

import br.com.lucasromagnoli.dailycalories.domain.DailyRegister;
import br.com.lucasromagnoli.dailycalories.domain.entities.DailyRegisterEntity;
import br.com.lucasromagnoli.dailycalories.domain.repository.DailyRegisterRepository;
import br.com.lucasromagnoli.dailycalories.domain.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveDailyRegisterUseCase implements UseCase<DailyRegister> {
    private final DailyRegisterRepository dailyRegisterRepository;

    @Override
    public DailyRegister handle(DailyRegister dailyRegister) {
        var dailyRegisterEntity = dailyRegisterRepository.save(DailyRegisterEntity.from(dailyRegister));
        return DailyRegister.from(dailyRegisterEntity);
    }
}
