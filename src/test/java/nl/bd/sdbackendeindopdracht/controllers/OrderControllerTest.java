package nl.bd.sdbackendeindopdracht.controllers;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import nl.bd.sdbackendeindopdracht.models.AppUser;
import nl.bd.sdbackendeindopdracht.models.Order;
import nl.bd.sdbackendeindopdracht.models.Parts;
import nl.bd.sdbackendeindopdracht.models.requestModels.OrderRequest;
import nl.bd.sdbackendeindopdracht.models.requestModels.PartsRequest;
import nl.bd.sdbackendeindopdracht.repos.OrderRepository;
import nl.bd.sdbackendeindopdracht.security.enums.Roles;
import nl.bd.sdbackendeindopdracht.services.OrderService;
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

@ContextConfiguration(classes = {OrderController.class})
@ExtendWith(SpringExtension.class)
class OrderControllerTest {
    @Autowired
    private OrderController orderController;

    @MockBean
    private OrderService orderService;

    /**
     * Method under test: {@link OrderController#getAllOrders()}
     */
    @Test
    void testGetAllOrders() throws Exception {
        when(this.orderService.getAllOrders()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/API/v1/orders/getAllOrders");
        MockMvcBuilders.standaloneSetup(this.orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link OrderController#getAllOrders()}
     */
    @Test
    void testGetAllOrders2() throws Exception {
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

        Order order = new Order();
        order.setCarBrand("?");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        order.setName("?");
        order.setOrderId(123L);
        order.setOrderNr(10.0d);
        order.setPartsList(new ArrayList<>());
        order.setTotalPrice(10.0d);
        order.setWorkedOnBy(appUser);

        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(order);
        when(this.orderService.getAllOrders()).thenReturn(orderList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/API/v1/orders/getAllOrders");
        MockMvcBuilders.standaloneSetup(this.orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    /**
     * Method under test: {@link OrderController#getAllOrders()}
     */
    @Test
    void testGetAllOrders3() throws Exception {
        when(this.orderService.getAllOrders()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/API/v1/orders/getAllOrders");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.orderController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link OrderController#getAllOrders()}
     */
    @Test
    void testGetAllOrders4() throws Exception {
        Parts parts = new Parts();
        parts.setPartName("?");
        parts.setPartPrice(10.0d);
        parts.setPartsId(123L);

        ArrayList<Parts> partsList = new ArrayList<>();
        partsList.add(parts);

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

        Order order = new Order();
        order.setCarBrand("?");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        order.setName("?");
        order.setOrderId(123L);
        order.setOrderNr(10.0d);
        order.setPartsList(partsList);
        order.setTotalPrice(10.0d);
        order.setWorkedOnBy(appUser);

        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(order);
        when(this.orderService.getAllOrders()).thenReturn(orderList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/API/v1/orders/getAllOrders");
        MockMvcBuilders.standaloneSetup(this.orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    /**
     * Method under test: {@link OrderController#addPartsToOrder(Long, PartsRequest)}
     */
    @Test
    void testAddPartsToOrder() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .put("/API/v1/orders/mechanic/addPartsToOrder/order={orderId}", "Uri Vars", "Uri Vars")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new PartsRequest("Part Name", 10.0d)));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.orderController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link OrderController#deleteOrder(Long)}
     */
    @Test
    void testDeleteOrder() throws Exception {
        doNothing().when(this.orderService).deleteOrder((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/API/v1/orders/admin/deleteOrder");
        MockHttpServletRequestBuilder requestBuilder = deleteResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link OrderController#deleteOrder(Long)}
     */
    @Test
    void testDeleteOrder2() throws Exception {
        doNothing().when(this.orderService).deleteOrder((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/API/v1/orders/admin/deleteOrder");
        deleteResult.contentType("https://example.org/example");
        MockHttpServletRequestBuilder requestBuilder = deleteResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

