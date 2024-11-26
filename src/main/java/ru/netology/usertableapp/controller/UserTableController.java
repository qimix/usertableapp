package ru.netology.usertableapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
    public List<PersonEntity> getPersonByCityController(@RequestParam("city") String city) {
        return userTableService.getPersonsByCity(new PersonDto(city));
    }

    @PostMapping("/persons/create-person")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPersonController(@RequestBody PersonEntity personEntity) {
        userTableService.savePersonEntity(personEntity);
    }

    @PostMapping("/persons/delete-person")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePersonController(@RequestBody PersonEntity personEntity) {
        userTableService.deletePersonEntity(personEntity);
    }

    @PostMapping("/persons/update-person")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePersonController(@RequestBody PersonEntity personEntity) {
        userTableService.updatePersonEntity(personEntity);
    }

}