package ru.netology.usertableapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.usertableapp.dto.PersonDto;
import ru.netology.usertableapp.entity.PersonEntity;
import ru.netology.usertableapp.service.UserTableService;

import java.util.List;

@RestController
public class UserTableController {
    UserTableService userTableService;

    @Autowired
    public UserTableController(UserTableService userTableService) {
        this.userTableService = userTableService;
    }

    @GetMapping("/persons/by-city")
    public List<PersonEntity> dataService(@RequestParam("city") String city) {
        return userTableService.getPersonsByCity(new PersonDto(city));
    }
}