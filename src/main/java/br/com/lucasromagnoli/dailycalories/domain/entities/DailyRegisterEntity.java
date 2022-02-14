package br.com.lucasromagnoli.dailycalories.domain.entities;

import br.com.lucasromagnoli.dailycalories.domain.DailyRegister;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "daily_register")
public class DailyRegisterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    @ManyToOne
    private PersonEntity person;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="daily_register_id")
    private List<MealEntity> meals;

    public static DailyRegisterEntity from(DailyRegister dailyRegister) {
        var personEntity = new PersonEntity();
        personEntity.setId(dailyRegister.getPersonId());

        var dailyRegisterEntity = new DailyRegisterEntity();
        dailyRegisterEntity.setDate(dailyRegister.getDate());
        dailyRegisterEntity.setPerson(personEntity);
        return dailyRegisterEntity;
    }
}
