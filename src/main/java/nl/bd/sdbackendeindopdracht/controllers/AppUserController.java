package nl.bd.sdbackendeindopdracht.controllers;

import nl.bd.sdbackendeindopdracht.services.AppUserService;
import nl.bd.sdbackendeindopdracht.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("API/v1/appUser")
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }





}
