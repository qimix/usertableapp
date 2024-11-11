package ru.netology.usertableapp.dao;

import jakarta.persistence.*;
import jakarta.transaction.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier("personDao")
public class PersonDao {
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    @Qualifier("entityManagerFactory")
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    @Qualifier("entityManager")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public String getCity(String name) {
        try {
            Query query = entityManager.createNativeQuery("select city from persons where name like :name");
            query.setParameter("name", name);
            return String.valueOf(query.getFirstResult());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
