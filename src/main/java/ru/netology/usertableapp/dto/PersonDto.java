package ru.netology.usertableapp.dto;

import lombok.Data;

@Data
public class PersonDto {
    String name;

    public PersonDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
