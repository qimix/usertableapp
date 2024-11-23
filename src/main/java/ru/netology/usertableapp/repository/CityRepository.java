package ru.netology.usertableapp.repository;
import org.springframework.data.repository.CrudRepository;
import ru.netology.usertableapp.entity.PersonEntity;
import java.util.List;

public interface CityRepository extends CrudRepository<PersonEntity, Long> {
    List<PersonEntity> findPersonEntityByCity(String city);
}
