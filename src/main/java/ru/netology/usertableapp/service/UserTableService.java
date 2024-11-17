package ru.netology.usertableapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.netology.usertableapp.dao.PersonDao;
import ru.netology.usertableapp.dto.PersonDto;
import ru.netology.usertableapp.entity.PersonEntity;

import java.util.List;
import java.util.Optional;

@Service
public class UserTableService {
    private PersonDao personDao;

    @Autowired
    @Qualifier("personDao")
    public void setCustomerDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public List<PersonEntity> getPersonsByCity(PersonDto personDto) {
        return personDao.getPersonsByCity(personDto.getCity());
    }
}
