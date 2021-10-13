package ru.renats.carmaintain.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.renats.carmaintain.entities.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * todo write javadoc!
 *
 * @author SadykovRI
 * @since 13.10.2021
 */
@RestController
@RequestMapping("/cars")
public class CarController {

    /**
     * Get all car data
     *
     * @return List<Car>
     */
    @GetMapping
    public List<Car> getAllCars() {
        return new ArrayList(Collections.singleton(Car.builder().id(0L).name("my classy incredible car").build()));
    }
}
