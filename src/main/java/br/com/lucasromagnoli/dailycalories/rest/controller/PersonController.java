package br.com.lucasromagnoli.dailycalories.rest.controller;

import br.com.lucasromagnoli.dailycalories.domain.Person;
import br.com.lucasromagnoli.dailycalories.domain.usecase.person.SavePersonUseCase;
import br.com.lucasromagnoli.dailycalories.rest.dto.PersonSave;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {
    private final SavePersonUseCase savePersonUseCase;
    @PostMapping
    private ResponseEntity<Person> save(@RequestBody PersonSave personSave) {
        var person = Person.from(personSave);
        return ResponseEntity.ok(person.save(savePersonUseCase));
    }
}
