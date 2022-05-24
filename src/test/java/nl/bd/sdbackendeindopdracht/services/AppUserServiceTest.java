package nl.bd.sdbackendeindopdracht.services;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import nl.bd.sdbackendeindopdracht.models.AppUser;
import nl.bd.sdbackendeindopdracht.models.requestModels.AppUserRequest;
import nl.bd.sdbackendeindopdracht.repos.AppUserRepository;
import nl.bd.sdbackendeindopdracht.security.enums.Roles;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AppUserService.class, BCryptPasswordEncoder.class})
@ExtendWith(SpringExtension.class)
class AppUserServiceTest {
    @MockBean
    private AppUserRepository appUserRepository;

    @Autowired
    private AppUserService appUserService;

    /**
     * Method under test: {@link AppUserService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        AppUser appUser = new AppUser();
        when(this.appUserRepository.findByUserName((String) any())).thenReturn(appUser);
        assertSame(appUser, this.appUserService.loadUserByUsername("janedoe"));
        verify(this.appUserRepository).findByUserName((String) any());
    }

    /**
     * Method under test: {@link AppUserService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        when(this.appUserRepository.findByUserName((String) any())).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> this.appUserService.loadUserByUsername("janedoe"));
        verify(this.appUserRepository).findByUserName((String) any());
    }

    /**
     * Method under test: {@link AppUserService#addNewUser(AppUserRequest)}
     */
    @Test
    void testAddNewUser() {
        AppUser appUser = new AppUser();
        appUser.setAddress("42 Main St");
        appUser.setEmail("jane.doe@example.org");
        appUser.setEnabled(true);
        appUser.setFullName("Dr Jane Doe");
        appUser.setFunction("Function");
        appUser.setLocked(true);
        appUser.setPassword("iloveyou");
        appUser.setUserId(123L);
        appUser.setUserRole(Roles.MECHANIC);
        appUser.setUsername("janedoe");
        when(this.appUserRepository.save((AppUser) any())).thenReturn(appUser);
        assertSame(appUser, this.appUserService.addNewUser(new AppUserRequest("Name", "janedoe", "jane.doe@example.org",
                "42 Main St", "iloveyou", Roles.MECHANIC, "Function")));
        verify(this.appUserRepository).save((AppUser) any());
    }


    /**
     * Method under test: {@link AppUserService#addNewUser(AppUserRequest)}
     */
    @Test
    void testAddNewUser3() {
        AppUser appUser = new AppUser();
        appUser.setAddress("42 Main St");
        appUser.setEmail("jane.doe@example.org");
        appUser.setEnabled(true);
        appUser.setFullName("Dr Jane Doe");
        appUser.setFunction("Function");
        appUser.setLocked(true);
        appUser.setPassword("iloveyou");
        appUser.setUserId(123L);
        appUser.setUserRole(Roles.MECHANIC);
        appUser.setUsername("janedoe");
        when(this.appUserRepository.save((AppUser) any())).thenReturn(appUser);
        AppUserRequest appUserRequest = mock(AppUserRequest.class);
        when(appUserRequest.getFunction()).thenThrow(new UsernameNotFoundException("Msg"));
        when(appUserRequest.getUserRole()).thenThrow(new UsernameNotFoundException("Msg"));
        when(appUserRequest.getAddress()).thenReturn("42 Main St");
        when(appUserRequest.getEmail()).thenReturn("jane.doe@example.org");
        when(appUserRequest.getName()).thenReturn("Name");
        when(appUserRequest.getPassword()).thenReturn("iloveyou");
        when(appUserRequest.getUsername()).thenReturn("janedoe");
        assertThrows(UsernameNotFoundException.class, () -> this.appUserService.addNewUser(appUserRequest));
        verify(appUserRequest).getAddress();
        verify(appUserRequest).getEmail();
        verify(appUserRequest).getName();
        verify(appUserRequest).getPassword();
        verify(appUserRequest).getUsername();
        verify(appUserRequest).getUserRole();
    }

    /**
     * Method under test: {@link AppUserService#getAllAppUsers()}
     */
    @Test
    void testGetAllAppUsers() {
        ArrayList<AppUser> appUserList = new ArrayList<>();
        when(this.appUserRepository.findAll()).thenReturn(appUserList);
        List<AppUser> actualAllAppUsers = this.appUserService.getAllAppUsers();
        assertSame(appUserList, actualAllAppUsers);
        assertTrue(actualAllAppUsers.isEmpty());
        verify(this.appUserRepository).findAll();
    }

    /**
     * Method under test: {@link AppUserService#getAllAppUsers()}
     */
    @Test
    void testGetAllAppUsers2() {
        when(this.appUserRepository.findAll()).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> this.appUserService.getAllAppUsers());
        verify(this.appUserRepository).findAll();
    }

    /**
     * Method under test: {@link AppUserService#deleteAppUser(Long)}
     */
    @Test
    void testDeleteAppUser() {
        doNothing().when(this.appUserRepository).deleteById((Long) any());
        this.appUserService.deleteAppUser(123L);
        verify(this.appUserRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link AppUserService#deleteAppUser(Long)}
     */
    @Test
    void testDeleteAppUser2() {
        doThrow(new RuntimeException("An error occurred")).when(this.appUserRepository).deleteById((Long) any());
        assertThrows(RuntimeException.class, () -> this.appUserService.deleteAppUser(123L));
        verify(this.appUserRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link AppUserService#editAppUser(AppUserRequest, Long)}
     */
    @Test
    void testEditAppUser() {
        AppUser appUser = new AppUser();
        appUser.setAddress("42 Main St");
        appUser.setEmail("jane.doe@example.org");
        appUser.setEnabled(true);
        appUser.setFullName("Dr Jane Doe");
        appUser.setFunction("Function");
        appUser.setLocked(true);
        appUser.setPassword("iloveyou");
        appUser.setUserId(123L);
        appUser.setUserRole(Roles.MECHANIC);
        appUser.setUsername("janedoe");
        Optional<AppUser> ofResult = Optional.of(appUser);

        AppUser appUser1 = new AppUser();
        appUser1.setAddress("42 Main St");
        appUser1.setEmail("jane.doe@example.org");
        appUser1.setEnabled(true);
        appUser1.setFullName("Dr Jane Doe");
        appUser1.setFunction("Function");
        appUser1.setLocked(true);
        appUser1.setPassword("iloveyou");
        appUser1.setUserId(123L);
        appUser1.setUserRole(Roles.MECHANIC);
        appUser1.setUsername("janedoe");
        when(this.appUserRepository.save((AppUser) any())).thenReturn(appUser1);
        when(this.appUserRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(appUser1, this.appUserService.editAppUser(new AppUserRequest("Name", "janedoe", "jane.doe@example.org",
                "42 Main St", "iloveyou", Roles.MECHANIC, "Function"), 123L));
        verify(this.appUserRepository).save((AppUser) any());
        verify(this.appUserRepository, atLeast(1)).findById((Long) any());
    }

    /**
     * Method under test: {@link AppUserService#editAppUser(AppUserRequest, Long)}
     */
    @Test
    void testEditAppUser2() {
        AppUser appUser = new AppUser();
        appUser.setAddress("42 Main St");
        appUser.setEmail("jane.doe@example.org");
        appUser.setEnabled(true);
        appUser.setFullName("Dr Jane Doe");
        appUser.setFunction("Function");
        appUser.setLocked(true);
        appUser.setPassword("iloveyou");
        appUser.setUserId(123L);
        appUser.setUserRole(Roles.MECHANIC);
        appUser.setUsername("janedoe");
        Optional<AppUser> ofResult = Optional.of(appUser);
        when(this.appUserRepository.save((AppUser) any())).thenThrow(new RuntimeException("An error occurred"));
        when(this.appUserRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(RuntimeException.class, () -> this.appUserService.editAppUser(new AppUserRequest("Name", "janedoe",
                "jane.doe@example.org", "42 Main St", "iloveyou", Roles.MECHANIC, "Function"), 123L));
        verify(this.appUserRepository).save((AppUser) any());
        verify(this.appUserRepository, atLeast(1)).findById((Long) any());
    }

    /**
     * Method under test: {@link AppUserService#editAppUser(AppUserRequest, Long)}
     */
    @Test
    void testEditAppUser3() {
        AppUser appUser = mock(AppUser.class);
        doNothing().when(appUser).setAddress((String) any());
        doNothing().when(appUser).setEmail((String) any());
        doNothing().when(appUser).setEnabled((Boolean) any());
        doNothing().when(appUser).setFullName((String) any());
        doNothing().when(appUser).setFunction((String) any());
        doNothing().when(appUser).setLocked((Boolean) any());
        doNothing().when(appUser).setPassword((String) any());
        doNothing().when(appUser).setUserId((Long) any());
        doNothing().when(appUser).setUserRole((Roles) any());
        doNothing().when(appUser).setUsername((String) any());
        appUser.setAddress("42 Main St");
        appUser.setEmail("jane.doe@example.org");
        appUser.setEnabled(true);
        appUser.setFullName("Dr Jane Doe");
        appUser.setFunction("Function");
        appUser.setLocked(true);
        appUser.setPassword("iloveyou");
        appUser.setUserId(123L);
        appUser.setUserRole(Roles.MECHANIC);
        appUser.setUsername("janedoe");
        Optional<AppUser> ofResult = Optional.of(appUser);

        AppUser appUser1 = new AppUser();
        appUser1.setAddress("42 Main St");
        appUser1.setEmail("jane.doe@example.org");
        appUser1.setEnabled(true);
        appUser1.setFullName("Dr Jane Doe");
        appUser1.setFunction("Function");
        appUser1.setLocked(true);
        appUser1.setPassword("iloveyou");
        appUser1.setUserId(123L);
        appUser1.setUserRole(Roles.MECHANIC);
        appUser1.setUsername("janedoe");
        when(this.appUserRepository.save((AppUser) any())).thenReturn(appUser1);
        when(this.appUserRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(appUser1, this.appUserService.editAppUser(new AppUserRequest("Name", "janedoe", "jane.doe@example.org",
                "42 Main St", "iloveyou", Roles.MECHANIC, "Function"), 123L));
        verify(this.appUserRepository).save((AppUser) any());
        verify(this.appUserRepository, atLeast(1)).findById((Long) any());
        verify(appUser, atLeast(1)).setAddress((String) any());
        verify(appUser, atLeast(1)).setEmail((String) any());
        verify(appUser).setEnabled((Boolean) any());
        verify(appUser, atLeast(1)).setFullName((String) any());
        verify(appUser, atLeast(1)).setFunction((String) any());
        verify(appUser).setLocked((Boolean) any());
        verify(appUser, atLeast(1)).setPassword((String) any());
        verify(appUser).setUserId((Long) any());
        verify(appUser, atLeast(1)).setUserRole((Roles) any());
        verify(appUser, atLeast(1)).setUsername((String) any());
    }

    /**
     * Method under test: {@link AppUserService#editAppUser(AppUserRequest, Long)}
     */
    @Test
    void testEditAppUser4() {
        AppUser appUser = new AppUser();
        appUser.setAddress("42 Main St");
        appUser.setEmail("jane.doe@example.org");
        appUser.setEnabled(true);
        appUser.setFullName("Dr Jane Doe");
        appUser.setFunction("Function");
        appUser.setLocked(true);
        appUser.setPassword("iloveyou");
        appUser.setUserId(123L);
        appUser.setUserRole(Roles.MECHANIC);
        appUser.setUsername("janedoe");
        when(this.appUserRepository.save((AppUser) any())).thenReturn(appUser);
        when(this.appUserRepository.findById((Long) any())).thenReturn(Optional.empty());
        AppUser appUser1 = mock(AppUser.class);
        doNothing().when(appUser1).setAddress((String) any());
        doNothing().when(appUser1).setEmail((String) any());
        doNothing().when(appUser1).setEnabled((Boolean) any());
        doNothing().when(appUser1).setFullName((String) any());
        doNothing().when(appUser1).setFunction((String) any());
        doNothing().when(appUser1).setLocked((Boolean) any());
        doNothing().when(appUser1).setPassword((String) any());
        doNothing().when(appUser1).setUserId((Long) any());
        doNothing().when(appUser1).setUserRole((Roles) any());
        doNothing().when(appUser1).setUsername((String) any());
        appUser1.setAddress("42 Main St");
        appUser1.setEmail("jane.doe@example.org");
        appUser1.setEnabled(true);
        appUser1.setFullName("Dr Jane Doe");
        appUser1.setFunction("Function");
        appUser1.setLocked(true);
        appUser1.setPassword("iloveyou");
        appUser1.setUserId(123L);
        appUser1.setUserRole(Roles.MECHANIC);
        appUser1.setUsername("janedoe");
        assertThrows(RuntimeException.class, () -> this.appUserService.editAppUser(new AppUserRequest("Name", "janedoe",
                "jane.doe@example.org", "42 Main St", "iloveyou", Roles.MECHANIC, "Function"), 123L));
        verify(this.appUserRepository).findById((Long) any());
        verify(appUser1).setAddress((String) any());
        verify(appUser1).setEmail((String) any());
        verify(appUser1).setEnabled((Boolean) any());
        verify(appUser1).setFullName((String) any());
        verify(appUser1).setFunction((String) any());
        verify(appUser1).setLocked((Boolean) any());
        verify(appUser1).setPassword((String) any());
        verify(appUser1).setUserId((Long) any());
        verify(appUser1).setUserRole((Roles) any());
        verify(appUser1).setUsername((String) any());
    }

}

