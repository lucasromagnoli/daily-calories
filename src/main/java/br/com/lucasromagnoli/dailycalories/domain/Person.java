package br.com.lucasromagnoli.dailycalories.domain;

import br.com.lucasromagnoli.dailycalories.domain.entities.PersonEntity;
import br.com.lucasromagnoli.dailycalories.domain.usecase.person.SavePersonUseCase;
import br.com.lucasromagnoli.dailycalories.rest.dto.PersonSave;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Person {
    private Long id;
    private String name;
    private List<DailyRegister> registers;

    public static Person from(PersonEntity personEntity) {
        return Person.builder()
                .id(personEntity.getId())
                .name(personEntity.getName())
                .build();
    }

    public static Person from(PersonSave personSave) {
        return Person.builder()
                .name(personSave.getName())
                .build();
    }

    public Person save(SavePersonUseCase savePersonUseCase) {
        return savePersonUseCase.handle(this);
    }
}
