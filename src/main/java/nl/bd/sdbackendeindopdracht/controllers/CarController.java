package nl.bd.sdbackendeindopdracht.controllers;

import nl.bd.sdbackendeindopdracht.models.Car;
import nl.bd.sdbackendeindopdracht.services.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/API/v1/cars")
public class CarController<CarService> {

    @Autowired
    GarageService garageService;

    @GetMapping("/getAllCars")
    private List<Car> getAllCars()
    {
        return garageService.getAllCars;
    }



}
