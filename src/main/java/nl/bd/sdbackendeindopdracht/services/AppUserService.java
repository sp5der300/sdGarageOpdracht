package nl.bd.sdbackendeindopdracht.services;

import lombok.AllArgsConstructor;
import nl.bd.sdbackendeindopdracht.models.AppUser;
import nl.bd.sdbackendeindopdracht.models.requestModels.AppUserRequest;
import nl.bd.sdbackendeindopdracht.repos.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByUserName(username);
    }

    public AppUser addNewUser(AppUserRequest appUserRequest) {
        AppUser newUser = AppUser.builder()
                .fullName(appUserRequest.getName())
                .username(appUserRequest.getUsername())
                .email(appUserRequest.getEmail())
                .address(appUserRequest.getAddress())
                .password(bCryptPasswordEncoder.encode(appUserRequest.getPassword()))
                .userRole(appUserRequest.getUserRole())
                .locked(false)
                .enabled(true)
                .function(appUserRequest.getFunction())
                .build();
        return appUserRepository.save(newUser);
    }

    public List<AppUser> getAllAppUsers() {
        return appUserRepository.findAll();
    }

    public void deleteAppUser(Long id) {
        appUserRepository.deleteById(id);
    }

    public AppUser editAppUser(AppUserRequest appUser, Long appUserId) {
        AppUser appUserFromDatabase;
        if (appUserRepository.findById(appUserId).isEmpty()){
            throw new RuntimeException("AppUser is empty or does not exist.");
        }
        else{
            appUserFromDatabase = appUserRepository.findById(appUserId).get();
            appUserFromDatabase.setFullName(appUser.getName());
            appUserFromDatabase.setUsername(appUser.getUsername());
            appUserFromDatabase.setAddress(appUser.getAddress());
            appUserFromDatabase.setEmail(appUser.getEmail());
            appUserFromDatabase.setPassword(appUser.getPassword());
            appUserFromDatabase.setUserRole(appUser.getUserRole());
            appUserFromDatabase.setFunction(appUser.getFunction());
        }
        return appUserRepository.save(appUserFromDatabase);
    }
}
