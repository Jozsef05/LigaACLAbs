package com.fev.app.WebApplication.user;

import com.fev.app.WebApplication.car.Car;
import com.fev.app.WebApplication.car.CarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Here is all the business logic of the application.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent())
            throw new UserNotFoundException("id - " + id);

        return user.get();
    }

    public List<Car> findAllCarsForUser(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent())
            throw new UserNotFoundException("No car for this user.");

        if (userOptional.get().getCars().isEmpty())
            throw new CarNotFoundException("No car for this user.");

        return userOptional.get().getCars();
    }

    public String getDetailsForCar(Integer userId, Integer carId) {
        /* TODO 5: implement this method as it follows:
        *   1. get the user you need from DB
        *   HINT: it can be Optional
        *   2. get its cars and search for the one you need.
        *
        *   Throw exception if the user/car was not found.
        *
        *   HINT : check the method "findAllCarsForUser()"*/

        return null;
    }

    public URI save(User user) {
        User savedUser = userRepository.save(user);
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
