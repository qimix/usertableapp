package ru.netology.usertableapp.dao;

import jakarta.persistence.*;
import jakarta.transaction.*;
import jakarta.transaction.RollbackException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier("personDao")
public class PersonDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Usertableapp");
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Transactional
    public String getCity(String name){
        try {
            Query query = entityManager.createNativeQuery("select city from persons where name like :name");
            query.setParameter("name", name);
            return String.valueOf(query.getFirstResult());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
