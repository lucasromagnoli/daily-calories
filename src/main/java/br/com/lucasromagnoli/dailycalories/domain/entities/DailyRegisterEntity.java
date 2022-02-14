package br.com.lucasromagnoli.dailycalories.domain.entities;

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
    @OneToMany
    @JoinColumn(name="daily_register_id")
    private List<MealEntity> meals;
}
