package br.com.lucasromagnoli.dailycalories.domain;

import br.com.lucasromagnoli.dailycalories.domain.entities.DailyRegisterEntity;
import br.com.lucasromagnoli.dailycalories.domain.usecase.register.SaveDailyRegisterUseCase;
import br.com.lucasromagnoli.dailycalories.rest.dto.DailyRegisterSave;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
public class DailyRegister {
    private Long id;
    private Long personId;
    private LocalDate date;
    private List<Meal> meals;

    public static DailyRegister from(DailyRegisterEntity dailyRegisterEntity) {
        return DailyRegister.builder()
                .id(dailyRegisterEntity.getId())
                .personId(Objects.nonNull(dailyRegisterEntity.getPerson())
                        ? dailyRegisterEntity.getPerson().getId()
                        : null)
                .date(dailyRegisterEntity.getDate())
                .build();
    }

    public static DailyRegister from(DailyRegisterSave dailyRegisterSave) {
        return DailyRegister.builder()
                .personId(dailyRegisterSave.getPersonId())
                .date(dailyRegisterSave.getDate())
                .build();
    }

    public DailyRegister save(SaveDailyRegisterUseCase saveDailyRegisterUseCase) {
        return saveDailyRegisterUseCase.handle(this);
    }
}
