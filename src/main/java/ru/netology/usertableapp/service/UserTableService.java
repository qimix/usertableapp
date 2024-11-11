package ru.netology.usertableapp.service;

import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.netology.usertableapp.dao.PersonDao;
import ru.netology.usertableapp.dto.PersonDto;

@Service
public class UserTableService {
    private PersonDao personDao;

    @Autowired
    @Qualifier("personDao")
    public void setCustomerDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public String getCity(PersonDto personDto) {
        return personDao.getCity(personDto.getName());
    }
}
