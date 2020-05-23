package com.fev.app.WebApplication.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * We wanted to have our own method that will select users by name.
 */
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    public List<Integer> findByName(String name) {
        String sqlQuery = "SELECT id FROM user where name= ? ";
        Query query = entityManager.createNativeQuery(sqlQuery);
        query.setParameter(1, name);

        return query.getResultList();
    }

    // TODO 7: write a function
}
