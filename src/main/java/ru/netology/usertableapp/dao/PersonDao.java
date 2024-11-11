package ru.netology.usertableapp.dao;

import jakarta.persistence.*;
import jakarta.transaction.*;
import jakarta.transaction.RollbackException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.netology.usertableapp.dto.PersonReq;

@Repository
@Qualifier("personDao")
public class PersonDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "Usertableapp" );
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Transactional
    public String getCity(PersonReq personReq) throws HeuristicRollbackException, SystemException, HeuristicMixedException, RollbackException {
        String name = personReq.getName();
        try{
        Query query = entityManager.createNativeQuery("select city from persons where name like :name");
        query.setParameter("name", name);
        return String.valueOf(query.getFirstResult());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
