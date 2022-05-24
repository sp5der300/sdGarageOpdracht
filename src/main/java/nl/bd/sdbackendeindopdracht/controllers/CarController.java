package nl.bd.sdbackendeindopdracht.controllers;

import com.lowagie.text.DocumentException;
import nl.bd.sdbackendeindopdracht.models.Car;
import nl.bd.sdbackendeindopdracht.security.config.PdfExport;
import nl.bd.sdbackendeindopdracht.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/API/v1/car")

public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/allCars")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable("id") Long id){
        return carService.getCarById(id);
    }

    @PostMapping("/admin/addNewCar")
    public Car addNewCar(@RequestBody Car car){
        return carService.addNewCar(car);
    }

    @PutMapping("/{id}")
    public Car editCar(@RequestBody Car car, @PathVariable("id") Long id){
        return carService.editCar(id, car);
    }

    @DeleteMapping("/admin/deleteCar")
    public void deleteCar(Long id){
        carService.deleteCar(id);
    }

    @GetMapping("/export/PDF")
    public void exportToPdf(HttpServletResponse response) throws DocumentException, IOException{
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormat.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue= "attachment; filename=classes_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Car> carList = carService.getAllCars();
        PdfExport exporter = new PdfExport(carList);
        exporter.export(response);
    }

}
