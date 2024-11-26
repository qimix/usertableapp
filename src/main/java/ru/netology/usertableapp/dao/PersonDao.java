package ru.netology.usertableapp.dao;

import jakarta.transaction.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.netology.usertableapp.entity.PersonEntity;
import ru.netology.usertableapp.repository.PersonRepository;

import java.util.List;


@Component
public class PersonDao {
    @Autowired
    @Qualifier("personRepository")
    PersonRepository personRepository;

    @Transactional
    public List<PersonEntity> getPersonsByCity(String city) {
        return personRepository.findPersonEntityByCity(city);
    }

    @Transactional
    public void savePersonEntity(PersonEntity personEntity) {
        personRepository.save(personEntity);
    }

    @Transactional
    public void deletePersonEntity(PersonEntity personEntity) {
        personRepository.delete(personEntity);
    }

}
