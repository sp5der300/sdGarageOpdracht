package nl.bd.sdbackendeindopdracht.services;

import nl.bd.sdbackendeindopdracht.models.Car;
import nl.bd.sdbackendeindopdracht.models.Customer;
import nl.bd.sdbackendeindopdracht.models.Mechanic;
import nl.bd.sdbackendeindopdracht.models.Order;
import nl.bd.sdbackendeindopdracht.models.requestModels.MechanicRequest;
import nl.bd.sdbackendeindopdracht.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkersService {
    @Autowired
    private WorkersRepository workersRepo;
    @Autowired
    private OrderRepository ordersRepo;
    @Autowired
    private MechanicRepository mechanicRepo;
    @Autowired
    private PaymentsRepository paymentsRepo;
    @Autowired
    private CustomerRepository customerRepo;
    @Autowired
    private CarRepository carRepo;

    public void newCar (Car newCar){
        carRepo.save(newCar);
    }

    public void newCustomer (Customer newCustomer){
        customerRepo.save(newCustomer);
    }

    public void newOrder (Order newOrder){
        ordersRepo.save(newOrder);
    }


    public Mechanic addNewMechanic(MechanicRequest mechanicRequest) {
        return null;
    }
}
