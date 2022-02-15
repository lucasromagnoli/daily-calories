package br.com.lucasromagnoli.dailycalories.domain;

import br.com.lucasromagnoli.dailycalories.domain.entities.DailyRegisterEntity;
import br.com.lucasromagnoli.dailycalories.domain.usecase.register.ListDailyRegisterUseCase;
import br.com.lucasromagnoli.dailycalories.domain.usecase.register.SaveDailyRegisterUseCase;
import br.com.lucasromagnoli.dailycalories.rest.dto.DailyRegisterSave;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
                .meals(CollectionUtils.isEmpty(dailyRegisterEntity.getMeals())
                        ? null
                        : dailyRegisterEntity.getMeals()
                            .stream()
                            .map(Meal::from)
                            .collect(Collectors.toList()))
                .date(dailyRegisterEntity.getDate())
                .build();
    }

    public static List<DailyRegister> from(List<DailyRegisterEntity> dailyRegisterEntities) {
        return dailyRegisterEntities
                .stream()
                .map(DailyRegister::from)
                .collect(Collectors.toList());
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

    public static List<DailyRegister> list(ListDailyRegisterUseCase listDailyRegisterUseCase) {
        return listDailyRegisterUseCase.handle();
    }
}
