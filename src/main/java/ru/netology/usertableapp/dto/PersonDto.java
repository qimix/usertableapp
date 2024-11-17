package ru.netology.usertableapp.dto;

import lombok.Data;

@Data
public class PersonDto {
    String city;

    public PersonDto(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}
