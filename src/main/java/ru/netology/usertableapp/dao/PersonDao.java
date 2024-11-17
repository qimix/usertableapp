package ru.netology.usertableapp.dao;

import jakarta.persistence.*;
import jakarta.transaction.*;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.netology.usertableapp.entity.PersonEntity;

import java.util.ArrayList;
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
    public List<PersonEntity> getPersonsByCity(String city) {
        try {
            Query query = entityManager.createNativeQuery("select * from persons where city = :city", PersonEntity.class);
            query.setParameter("city", city);
            List<PersonEntity> personEntityList = query.getResultList();
            return personEntityList;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
