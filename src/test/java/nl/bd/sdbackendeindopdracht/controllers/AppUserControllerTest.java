package nl.bd.sdbackendeindopdracht.controllers;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import nl.bd.sdbackendeindopdracht.models.AppUser;
import nl.bd.sdbackendeindopdracht.models.requestModels.AppUserRequest;
import nl.bd.sdbackendeindopdracht.repos.AppUserRepository;
import nl.bd.sdbackendeindopdracht.security.enums.Roles;
import nl.bd.sdbackendeindopdracht.services.AppUserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AppUserController.class})
@ExtendWith(SpringExtension.class)
class AppUserControllerTest {
    @Autowired
    private AppUserController appUserController;

    @MockBean
    private AppUserService appUserService;


    /**
     * Method under test: {@link AppUserController#getAllAppUsers()}
     */
    @Test
    void testGetAllAppUsers() throws Exception {
        when(this.appUserService.getAllAppUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/API/v1/appUser/getAllAppUsers");
        MockMvcBuilders.standaloneSetup(this.appUserController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AppUserController#getAllAppUsers()}
     */
    @Test
    void testGetAllAppUsers2() throws Exception {
        AppUser appUser = new AppUser();
        appUser.setAddress("42 Main St");
        appUser.setEmail("jane.doe@example.org");
        appUser.setEnabled(true);
        appUser.setFullName("Dr Jane Doe");
        appUser.setFunction("?");
        appUser.setLocked(true);
        appUser.setPassword("iloveyou");
        appUser.setUserId(123L);
        appUser.setUserRole(Roles.MECHANIC);
        appUser.setUsername("janedoe");

        ArrayList<AppUser> appUserList = new ArrayList<>();
        appUserList.add(appUser);
        when(this.appUserService.getAllAppUsers()).thenReturn(appUserList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/API/v1/appUser/getAllAppUsers");
        MockMvcBuilders.standaloneSetup(this.appUserController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    /**
     * Method under test: {@link AppUserController#getAllAppUsers()}
     */
    @Test
    void testGetAllAppUsers3() throws Exception {
        when(this.appUserService.getAllAppUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/API/v1/appUser/getAllAppUsers");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.appUserController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AppUserController#deleteAppUser(Long)}
     */
    @Test
    void testDeleteAppUser() throws Exception {
        doNothing().when(this.appUserService).deleteAppUser((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/API/v1/appUser/admin/deleteAppUser");
        MockHttpServletRequestBuilder requestBuilder = deleteResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.appUserController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link AppUserController#deleteAppUser(Long)}
     */
    @Test
    void testDeleteAppUser2() throws Exception {
        doNothing().when(this.appUserService).deleteAppUser((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/API/v1/appUser/admin/deleteAppUser");
        deleteResult.contentType("https://example.org/example");
        MockHttpServletRequestBuilder requestBuilder = deleteResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.appUserController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}

