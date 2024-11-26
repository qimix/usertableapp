package ru.netology.usertableapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.netology.usertableapp.entity.PersonEntity;

public interface SavePersonRepository extends CrudRepository<PersonEntity, Long> {
}
