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

/**
 * In the CONTROLLER we have all the ENDPOINTS, that
 * "belongs" to the "User" entity.
 *
 * Every method form here is an ENDPOINT and it will call
 * a method form the SERVICE, which will call a Repository method.
 *
 * CONTROLLER -> SERVICE(business logic) -> REPOSITORY(read/write data in DB)
 *
 * And also the other way around.
 */
@RestController
public class UserController {

    /**
     * Because we are using the Spring framework all the
     * dependencies are solved by the IoC container.
     */
    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    /**
     * This is an ENDPOINT.
     *
     * @return all users from DB.
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/jpa/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/jpa/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        /* TODO 1: user userService to implement this method
        *   HINT: check <getAllUsers()> */
        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/jpa/users/{id}/cars", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> getAllCarsForUser(@PathVariable Integer id) {
        /* TODO 2: implement this function*/
        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/jpa/users/{userId}/cars/{carId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getDetailsForCar(@PathVariable Integer userId, @PathVariable Integer carId) {
        /* TODO 3: implement this function using the userService
        *   TODO 4: the service method is also not implement */
        return null;
    }

    /**
     * creates an User
     *
     * @param user the body of the new user as JSON
     * @return Status : 201 Created
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        URI location = userService.save(user);
        return ResponseEntity.created(location).build();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/jpa/users/{id}/cars")
    public ResponseEntity<Object> createCar(@PathVariable Integer userId, @RequestBody Car car) {
        /* TODO 6: save the car that is sent at this ENDPOINT.
        *   ! you should get the user first.
        *   NO HINTS */

        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/jpa/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }
}
