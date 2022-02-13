package br.com.lucasromagnoli.dailycalories.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

public enum UnityEnum {
    Milliliter("ml", 0),
    Liter("l", 1),
    Gram("g", 2),
    Kilogram("kg", 3),
    Unity("unit", 4);

    @Getter
    private final String abbreviation;
    private final Integer code;

    UnityEnum(String abbreviation, Integer code) {
        this.abbreviation = abbreviation;
        this.code = code;
    }

    public static UnityEnum getByCode(Integer code) {
        return Arrays.stream(values())
                .filter(unityEnum -> unityEnum.code.equals(code))
                .findFirst().orElse(null);
    }

    public static UnityEnum getByAbbreviation(String abbreviation) {
        return Arrays.stream(values())
                .filter(unityEnum -> unityEnum.abbreviation.equalsIgnoreCase(abbreviation))
                .findFirst().orElse(null);
    }

    public static UnityEnum getByAbbreviationOrCode(Object codeOrAbbreviation) {
        if (Objects.nonNull(codeOrAbbreviation)) {
            if (codeOrAbbreviation instanceof Integer) {
                return getByCode(((Integer) codeOrAbbreviation));
            } else if (codeOrAbbreviation instanceof String) {
                String codeOrAbbreviationStringTyped = (String) codeOrAbbreviation;
                return codeOrAbbreviationStringTyped.matches("\\d+")
                        ? getByCode(Integer.valueOf(codeOrAbbreviationStringTyped))
                        : getByAbbreviation(codeOrAbbreviationStringTyped);
            }
        }

        return null;
    }
}
