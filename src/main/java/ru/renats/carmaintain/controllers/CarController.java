package ru.renats.carmaintain.controllers;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping("/allcars")
    public ModelAndView getAllCars(Map<String, Object> model) {

//        Page<Car> employeesPageable(Pageable pageable) {
//            return carService.findAll(pageable);

        List<Car> carsList = (List<Car>) carService.findAll();
        model.put("cars", carsList);
        return new ModelAndView("carsview", model);
    }

    @RequestMapping(value = "/getcar", method = RequestMethod.GET)
    public ModelAndView show(@RequestParam int id, Map<String, Object> model) {
        Car car = carService.findById((long) id).orElseThrow();
        model.put("cars", ImmutableList.of(car));
        return new ModelAndView("carsview", model);
    }

//    @RequestMapping(value = "/edit/id")
//    public ModelAndView updateForm(@PathVariable Long id, Map<String, Object> model) {
//        model.put("car", carService.findById(id));
//        return new ModelAndView("carsview", model);
//    }

}
