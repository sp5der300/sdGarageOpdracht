package nl.bd.sdbackendeindopdracht.services;

import lombok.AllArgsConstructor;
import nl.bd.sdbackendeindopdracht.models.Car;
import nl.bd.sdbackendeindopdracht.repos.CarRepository;
import nl.bd.sdbackendeindopdracht.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    @Autowired
    CarRepository carRepo;

    public List<Car> getAllCars() {
        return carRepo.findAll();
    }

    public Car getCarById(Long id) {
        return carRepo.findById(id).get();
    }

    public Car addNewCar(Car car) {
        return carRepo.save(car);
    }

    public Car editCar(Long id, Car c) {
        return carRepo.findById(id)
                .map(
                        car -> {
                            car.setOrderNr(c.getOrderNr());
                            car.setCustomer(c.getCustomer());
                            car.setConstructionYear(c.getConstructionYear());
                            car.setWorkedOnBy(c.getWorkedOnBy());
                            return carRepo.save(car);
                        }
                ).orElseGet(() -> {
                    return addNewCar(c);
                });
    }

    public void deleteCar(Long id){
        carRepo.deleteById(id);
    }


}
