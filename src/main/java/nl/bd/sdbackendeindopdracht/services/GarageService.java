package nl.bd.sdbackendeindopdracht.services;

import nl.bd.sdbackendeindopdracht.models.Car;
import nl.bd.sdbackendeindopdracht.repos.CarRepository;
import nl.bd.sdbackendeindopdracht.repos.CustomerRepository;
import nl.bd.sdbackendeindopdracht.repos.MechanicRepository;
import nl.bd.sdbackendeindopdracht.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageService {

    public List<Car> getAllCars;
    @Autowired
    private CarRepository carRepo;
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private MechanicRepository mechanicRepo;
    @Autowired
    private CustomerRepository customerRepo;


}
