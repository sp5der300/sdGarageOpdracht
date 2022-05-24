package nl.bd.sdbackendeindopdracht.security.config;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.lowagie.text.DocumentException;

import java.io.IOException;
import java.util.ArrayList;

import nl.bd.sdbackendeindopdracht.models.AppUser;
import nl.bd.sdbackendeindopdracht.models.Car;
import nl.bd.sdbackendeindopdracht.security.enums.Roles;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletResponse;

class PdfExportTest {

    /**
     * Method under test: {@link PdfExport#export(javax.servlet.http.HttpServletResponse)}
     */
    @Test
    void testExport4() throws DocumentException, IOException {
        PdfExport pdfExport = new PdfExport(new ArrayList<>());
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        pdfExport.export(mockHttpServletResponse);
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link PdfExport#export(javax.servlet.http.HttpServletResponse)}
     */
    @Test
    void testExport5() throws DocumentException, IOException {
        AppUser appUser = new AppUser();
        appUser.setAddress("42 Main St");
        appUser.setEmail("jane.doe@example.org");
        appUser.setEnabled(true);
        appUser.setFullName("Dr Jane Doe");
        appUser.setFunction("Helvetica-Bold");
        appUser.setLocked(true);
        appUser.setPassword("iloveyou");
        appUser.setUserId(123L);
        appUser.setUserRole(Roles.MECHANIC);
        appUser.setUsername("");

        AppUser appUser1 = new AppUser();
        appUser1.setAddress("42 Main St");
        appUser1.setEmail("jane.doe@example.org");
        appUser1.setEnabled(true);
        appUser1.setFullName("Dr Jane Doe");
        appUser1.setFunction("Helvetica-Bold");
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

        ArrayList<Car> carList = new ArrayList<>();
        carList.add(car);
        PdfExport pdfExport = new PdfExport(carList);
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        pdfExport.export(mockHttpServletResponse);
        assertTrue(mockHttpServletResponse.isCommitted());
    }
}

