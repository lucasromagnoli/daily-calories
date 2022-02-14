package br.com.lucasromagnoli.dailycalories.domain.usecase.person;

import br.com.lucasromagnoli.dailycalories.domain.Person;
import br.com.lucasromagnoli.dailycalories.domain.entities.PersonEntity;
import br.com.lucasromagnoli.dailycalories.domain.repository.PersonRepository;
import br.com.lucasromagnoli.dailycalories.domain.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SavePersonUseCase implements UseCase<Person> {
    private final PersonRepository personRepository;

    @Override
    public Person handle(Person person) {
        var personEntity = personRepository.save(PersonEntity.from(person));
        return Person.from(personEntity);
    }
}
