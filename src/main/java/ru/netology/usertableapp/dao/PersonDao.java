package ru.netology.usertableapp.dao;

import jakarta.persistence.*;
import jakarta.transaction.*;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.netology.usertableapp.entity.PersonEntity;

import java.util.List;
import java.util.Optional;


@Repository
@Qualifier("personDao")
public class PersonDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    @Qualifier("entityManager")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Optional<PersonEntity> getPersonsByCity(String name) {
        try {
            Query query = entityManager.createNativeQuery("select * from persons where name = :name", PersonEntity.class);
            return Optional.of((PersonEntity)query.setParameter("name", name).getSingleResult());
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
