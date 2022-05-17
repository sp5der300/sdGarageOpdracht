package nl.bd.sdbackendeindopdracht.controllers;

import nl.bd.sdbackendeindopdracht.models.Car;
import nl.bd.sdbackendeindopdracht.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/v1/car")

public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable("id") Long id){
        return carService.getCarById(id);
    }

    @PostMapping("/")
    public Car addNewCar(@RequestBody Car car){
        return carService.addNewCar(car);
    }

    @PutMapping("/{id}")
    public Car editCar(@RequestBody Car car, @PathVariable("id") Long id){
        return carService.editCar(id, car);
    }

    @DeleteMapping
    public void deleteCar(Long id){
        carService.deleteCar(id);
    }



}
