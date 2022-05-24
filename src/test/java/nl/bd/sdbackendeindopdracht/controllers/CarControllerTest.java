package nl.bd.sdbackendeindopdracht.controllers;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import nl.bd.sdbackendeindopdracht.models.AppUser;
import nl.bd.sdbackendeindopdracht.models.Car;
import nl.bd.sdbackendeindopdracht.repos.CarRepository;
import nl.bd.sdbackendeindopdracht.security.enums.Roles;
import nl.bd.sdbackendeindopdracht.services.CarService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CarController.class})
@ExtendWith(SpringExtension.class)
class CarControllerTest {
    @Autowired
    private CarController carController;

    @MockBean
    private CarService carService;

    /**
     * Method under test: {@link CarController#getAllCars()}
     */
    @Test
    void testGetAllCars() throws Exception {
        when(this.carService.getAllCars()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/API/v1/car/allCars");
        MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CarController#getAllCars()}
     */
    @Test
    void testGetAllCars2() throws Exception {
        when(this.carService.getAllCars()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/API/v1/car/allCars");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CarController#getCarById(Long)}
     */
    @Test
    void testGetCarById() throws Exception {
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

        Car car = new Car();
        car.setCarId(123L);
        car.setConstructionYear(1);
        car.setCustomer(appUser);
        car.setOrderNr(1);
        car.setWorkedOnBy(appUser1);
        when(this.carService.getCarById((Long) any())).thenReturn(car);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/API/v1/car/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    /**
     * Method under test: {@link CarController#getCarById(Long)}
     */
    @Test
    void testGetCarById2() throws Exception {
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

        Car car = new Car();
        car.setCarId(123L);
        car.setConstructionYear(1);
        car.setCustomer(appUser);
        car.setOrderNr(1);
        car.setWorkedOnBy(appUser1);
        when(this.carService.getCarById((Long) any())).thenReturn(car);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/API/v1/car/{id}", 123L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }


    /**
     * Method under test: {@link CarController#deleteCar(Long)}
     */
    @Test
    void testDeleteCar() throws Exception {
        doNothing().when(this.carService).deleteCar((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/API/v1/car/admin/deleteCar");
        MockHttpServletRequestBuilder requestBuilder = deleteResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link CarController#deleteCar(Long)}
     */
    @Test
    void testDeleteCar2() throws Exception {
        doNothing().when(this.carService).deleteCar((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/API/v1/car/admin/deleteCar");
        deleteResult.contentType("https://example.org/example");
        MockHttpServletRequestBuilder requestBuilder = deleteResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link CarController#editCar(Car, Long)}
     */
    @Test
    void testEditCar() throws Exception {
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

        Car car = new Car();
        car.setCarId(123L);
        car.setConstructionYear(1);
        car.setCustomer(appUser);
        car.setOrderNr(1);
        car.setWorkedOnBy(appUser1);
        String content = (new ObjectMapper()).writeValueAsString(car);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/API/v1/car/{id}", "", "Uri Vars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

