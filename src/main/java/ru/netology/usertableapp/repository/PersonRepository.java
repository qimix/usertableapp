package ru.netology.usertableapp.repository;
import org.springframework.data.repository.CrudRepository;
import ru.netology.usertableapp.dto.PersonDto;
import ru.netology.usertableapp.entity.PersonEntity;
import java.util.List;

public interface PersonRepository extends CrudRepository<PersonEntity, Long> {
    List<PersonEntity> findPersonEntityByCity(String city);
}
