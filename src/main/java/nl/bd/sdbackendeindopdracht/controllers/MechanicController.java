package nl.bd.sdbackendeindopdracht.controllers;

import nl.bd.sdbackendeindopdracht.models.Mechanic;
import nl.bd.sdbackendeindopdracht.models.requestModels.MechanicRequest;
import nl.bd.sdbackendeindopdracht.services.WorkersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("API/v1/mechanic")
@RestController

public class MechanicController {

    private final WorkersService workersService;

    public MechanicController(WorkersService workersService) {
        this.workersService = workersService;
    }

    @PostMapping("/newMechanic")
    public Mechanic newMechanic (@RequestBody MechanicRequest mechanicRequest){
        return workersService.addNewMechanic(mechanicRequest);
    }





}
