package br.com.lucasromagnoli.dailycalories.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Person {
    private String name;
    private List<DailyRegister> registers;
}
