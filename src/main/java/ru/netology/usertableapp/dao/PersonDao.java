package ru.netology.usertableapp.dao;

import jakarta.transaction.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.netology.usertableapp.entity.PersonEntity;
import ru.netology.usertableapp.repository.CityRepository;

import java.util.List;


@Component
public class PersonDao {
    @Autowired
    @Qualifier("cityRepository")
    CityRepository cityRepository;

    @Transactional
    public List<PersonEntity> getPersonsByCity(String city) {
        return cityRepository.findPersonEntityByCity(city);
    }
}
