package nl.bd.sdbackendeindopdracht.repos;

import nl.bd.sdbackendeindopdracht.models.AppUser;
import nl.bd.sdbackendeindopdracht.security.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Query("SELECT s FROM AppUser s WHERE s.username =?1")
    UserDetails findByUserName(String username);

    @Query("select s from AppUser s where s.userRole = ?1")
    Optional<AppUser> findByRoleEnum(Roles userRole);
}
