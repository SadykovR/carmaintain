package ru.renats.carmaintain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.renats.carmaintain.entities.Car;
import ru.renats.carmaintain.services.CarService;

import java.util.List;
import java.util.Map;

/**
 * todo write javadoc!
 *
 * @author SadykovRI
 * @since 13.10.2021
 */
@RestController
@Controller
public class CarController {

    @Autowired
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    public CarController() {
    }

    /**
     * Get all car data as Json
     *
     * @return List<Car>
     */
    @RequestMapping("/cars")
    public List<Car> getAllCars() {
        return (List<Car>) carService.findAll();
    }

    /**
     * Get all car data
     */
    @RequestMapping("/all")
    public ModelAndView getPlayers(Map<String, Object> model) {
        List<Car> playersList = (List<Car>) carService.findAll();
        model.put("cars", playersList);
        return new ModelAndView("carsview", model);
    }

}
