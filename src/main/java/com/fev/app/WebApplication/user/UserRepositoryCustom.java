package com.fev.app.WebApplication.user;

import java.util.List;

/**
 * This is the interface for our custom repository.
 */
public interface UserRepositoryCustom {

    List<Integer> findByName(String name);
}
