package br.com.lucasromagnoli.dailycalories.domain.entities;

import br.com.lucasromagnoli.dailycalories.domain.Person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn(name = "person_id")
    private List<DailyRegisterEntity> registers;

    public static PersonEntity from(Person person) {
        var personEntity = new PersonEntity();
        personEntity.setName(person.getName());
        return personEntity;
    }
}
