package br.com.lucasromagnoli.dailycalories.domain.usecase.register;

import br.com.lucasromagnoli.dailycalories.domain.DailyRegister;
import br.com.lucasromagnoli.dailycalories.domain.entities.DailyRegisterEntity;
import br.com.lucasromagnoli.dailycalories.domain.repository.DailyRegisterRepository;
import br.com.lucasromagnoli.dailycalories.domain.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListDailyRegisterUseCase implements UseCase<List<DailyRegister>> {
    private final DailyRegisterRepository dailyRegisterRepository;

    @Override
    public List<DailyRegister> handle() {
        List<DailyRegisterEntity> dailyRegisterEntities = dailyRegisterRepository.findAll();
        return DailyRegister.from(dailyRegisterEntities);
    }
}
