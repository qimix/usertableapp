package ru.netology.usertableapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public @ResponseBody ResponseEntity<String> createPersonController(@RequestBody PersonEntity personEntity) {
        userTableService.savePersonEntity(personEntity);
        return new ResponseEntity<String>("Create status: ok", HttpStatus.OK);
    }

    @PostMapping("/persons/delete-person")
    public @ResponseBody ResponseEntity<String> deletePersonController(@RequestBody PersonEntity personEntity) {
        userTableService.deletePersonEntity(personEntity);
        return new ResponseEntity<String>("Delete status: ok", HttpStatus.OK);
    }

    @PostMapping("/persons/update-person")
    public @ResponseBody ResponseEntity<String> updatePersonController(@RequestBody PersonEntity personEntity) {
        userTableService.updatePersonEntity(personEntity);
        return new ResponseEntity<String>("Update status: ok", HttpStatus.OK);
    }

}