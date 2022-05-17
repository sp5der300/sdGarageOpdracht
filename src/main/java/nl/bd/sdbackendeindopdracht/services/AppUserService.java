package nl.bd.sdbackendeindopdracht.services;

import lombok.AllArgsConstructor;
import nl.bd.sdbackendeindopdracht.models.AppUser;
import nl.bd.sdbackendeindopdracht.models.requestModels.AppUserRequest;
import nl.bd.sdbackendeindopdracht.repos.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByUserName(username);
    }

    public AppUser addNewUser(AppUserRequest appUserRequest) {
        AppUser newUser = AppUser.builder()
                .fullName(appUserRequest.getName())
                .username(appUserRequest.getUsername())
                .email(appUserRequest.getEmail())
                .password(appUserRequest.getPassword())
                .userRole(appUserRequest.getUserRole())
                .locked(false)
                .enabled(true)
                .function(appUserRequest.getFunction())
                .build();
        return appUserRepository.save(newUser);
    }

}
