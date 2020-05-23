package com.fev.app.WebApplication.user;

import com.fev.app.WebApplication.car.Car;

import com.fev.app.WebApplication.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/jpa/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/jpa/users/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/jpa/users/{id}/cars")
    public List<Car> getAllCarsForUser(@PathVariable Integer id) {
        return userService.findAllCarsForUser(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/jpa/users/{userId}/posts/{carId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getDetailsForPost(@PathVariable Integer userId, @PathVariable Integer carId) {
        return ResponseEntity.ok(userService.getDetailsForCar(userId, carId));
    }

    /**
     * creates an User
     *
     * @param user the body of the new user as JSON
     * @return Status : 201 Created
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        URI location = userService.save(user);

        return ResponseEntity.created(location).build();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable Integer userId, @RequestBody Car car) {
        User user = userService.findById(userId);
        car.setUser(user);
        URI location = carService.save(car);

        return ResponseEntity.created(location).build();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }
}
