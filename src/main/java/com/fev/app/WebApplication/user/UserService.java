package com.fev.app.WebApplication.user;

import com.fev.app.WebApplication.car.Car;

import java.net.URI;
import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Integer id);

    List<Car> findAllCarsForUser(Integer userId);

    String getDetailsForCar(Integer userId, Integer carId);

    URI save(User user);

    void deleteById(Integer id);

}
