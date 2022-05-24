package nl.bd.sdbackendeindopdracht.controllers;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import nl.bd.sdbackendeindopdracht.models.Parts;
import nl.bd.sdbackendeindopdracht.models.requestModels.PartsRequest;
import nl.bd.sdbackendeindopdracht.repos.PartsRepository;
import nl.bd.sdbackendeindopdracht.services.PartsService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PartsController.class})
@ExtendWith(SpringExtension.class)
class PartsControllerTest {
    @Autowired
    private PartsController partsController;

    @MockBean
    private PartsService partsService;

    /**
     * Method under test: {@link PartsController#getAllParts()}
     */
    @Test
    void testGetAllParts() throws Exception {
        when(this.partsService.getAllParts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/API/v1/parts/getAllParts");
        MockMvcBuilders.standaloneSetup(this.partsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PartsController#getAllParts()}
     */
    @Test
    void testGetAllParts2() throws Exception {
        Parts parts = new Parts();
        parts.setPartName("?");
        parts.setPartPrice(10.0d);
        parts.setPartsId(123L);

        ArrayList<Parts> partsList = new ArrayList<>();
        partsList.add(parts);
        when(this.partsService.getAllParts()).thenReturn(partsList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/API/v1/parts/getAllParts");
        MockMvcBuilders.standaloneSetup(this.partsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[{\"partsId\":123,\"partName\":\"?\",\"partPrice\":10.0}]"));
    }

    /**
     * Method under test: {@link PartsController#getAllParts()}
     */
    @Test
    void testGetAllParts3() throws Exception {
        when(this.partsService.getAllParts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/API/v1/parts/getAllParts");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.partsController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }


    /**
     * Method under test: {@link PartsController#deleteParts(Long)}
     */
    @Test
    void testDeleteParts() throws Exception {
        doNothing().when(this.partsService).deleteParts((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/API/v1/parts/admin/deleteParts");
        MockHttpServletRequestBuilder requestBuilder = deleteResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.partsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link PartsController#deleteParts(Long)}
     */
    @Test
    void testDeleteParts2() throws Exception {
        doNothing().when(this.partsService).deleteParts((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/API/v1/parts/admin/deleteParts");
        deleteResult.contentType("https://example.org/example");
        MockHttpServletRequestBuilder requestBuilder = deleteResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.partsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

