package nl.bd.sdbackendeindopdracht.controllers;

import nl.bd.sdbackendeindopdracht.models.AppUser;
import nl.bd.sdbackendeindopdracht.models.requestModels.AppUserRequest;
import nl.bd.sdbackendeindopdracht.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("API/v1/appUser")
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping("/newAppUser")
    public AppUser newAppUser(@RequestBody AppUserRequest request) {
        return appUserService.addNewUser(request);
    }

    @GetMapping("/getAllAppUsers")
    public List<AppUser> getAllAppUsers(){
        return appUserService.getAllAppUsers();
    }

    @DeleteMapping("/admin/deleteAppUser")
    public void deleteAppUser(Long id){
        appUserService.deleteAppUser(id);
    }

    @PutMapping("/admin/editAppUser")
    public AppUser editAppUser(@RequestBody AppUserRequest appUser, @PathVariable ("userId") Long appUserId){
        return appUserService.editAppUser(appUser, appUserId);
    }


}
