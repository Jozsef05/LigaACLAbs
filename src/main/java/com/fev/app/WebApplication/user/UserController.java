package com.fev.app.WebApplication.user;

import com.fev.app.WebApplication.car.Car;

import com.fev.app.WebApplication.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @GetMapping("/jpa/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @GetMapping("/jpa/users/{id}/cars")
    public List<Car> getAllCarsForUser(@PathVariable Integer id) {
        return userService.findAllCarsForUser(id);
    }

    @GetMapping("/jpa/users/{userId}/posts/{carId}")
    public String getDetailsForPost(@PathVariable Integer userId, @PathVariable Integer carId) {
        return userService.getDetailsForCar(userId, carId);
    }

    /**
     * creates an User
     *
     * @param user the body of the new user as JSON
     * @return Status : 201 Created
     */
    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        URI location = userService.save(user);

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable Integer userId, @RequestBody Car car) {
        User user = userService.findById(userId);
        car.setUser(user);
        URI location = carService.save(car);

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }
}
