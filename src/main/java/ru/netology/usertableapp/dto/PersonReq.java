package ru.netology.usertableapp.dto;

public class PersonReq {
    String name;

    public PersonReq(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
