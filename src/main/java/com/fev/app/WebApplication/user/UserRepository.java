package com.fev.app.WebApplication.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * In the JpaRepository we have the main methods
 * that are used when interacting with a database.
 *
 * If we want our own functions, we simply create an Interface
 * and the implementation and it will be extended by the
 * main repository class.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {

}
