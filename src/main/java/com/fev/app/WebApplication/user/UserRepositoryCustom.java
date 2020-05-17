package com.fev.app.WebApplication.user;

import java.util.List;

public interface UserRepositoryCustom {

    List<Integer> findByName(String name);
}
