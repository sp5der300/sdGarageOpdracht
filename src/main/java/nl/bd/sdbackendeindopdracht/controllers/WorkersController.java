package nl.bd.sdbackendeindopdracht.controllers;

import nl.bd.sdbackendeindopdracht.services.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WorkersController {

    @Autowired
    private WorkersService workersService;




}
