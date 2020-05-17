package com.fev.app.WebApplication.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class CarServiceImpl {

    @Autowired
    private CarRepository carRepository;

    public URI save(Car car) {
        Car savedCar = carRepository.save(car);
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCar.getId())
                .toUri();
    }
}
