package nl.bd.sdbackendeindopdracht.security.config;

import lombok.AllArgsConstructor;
import nl.bd.sdbackendeindopdracht.models.AppUser;
import nl.bd.sdbackendeindopdracht.repos.AppUserRepository;
import nl.bd.sdbackendeindopdracht.security.enums.Roles;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@AllArgsConstructor
public class DevelopmentConfiguration {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    CommandLineRunner commandLineRunner(
            AppUserRepository appUserRepository
    ) {
        return args -> {
            if (appUserRepository.findByRoleEnum(Roles.ADMIN).isEmpty()) {
                AppUser admin = AppUser.builder()
                        .username("Admin")
                        .locked(false)
                        .enabled(true)
                        .password(bCryptPasswordEncoder.encode("sp5der"))
                        .userRole(Roles.ADMIN)
                        .build();
                appUserRepository.save(admin);
            }
        };
    }
}
