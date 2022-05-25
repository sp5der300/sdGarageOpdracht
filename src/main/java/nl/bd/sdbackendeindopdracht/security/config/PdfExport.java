package nl.bd.sdbackendeindopdracht.security.config;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import nl.bd.sdbackendeindopdracht.models.Car;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class PdfExport {

    private List<Car> carListPdf;
    public PdfExport(List<Car> carListPdf){
        this.carListPdf = carListPdf;
    }

    private void writeTableHeader(PdfPTable table)
    {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Car ID:", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Construction year:", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Order Nr:", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Customer ID:", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Worked on by ID:", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table)
    {
        for(Car car : carListPdf)
        {
            table.addCell(String.valueOf(car.getCarId()));
            table.addCell(String.valueOf(car.getConstructionYear()));
            table.addCell(String.valueOf(car.getOrderNr()));
            table.addCell(car.getCustomer().getUsername());
            table.addCell(car.getWorkedOnBy().getUsername());
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException
    {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("List of cars", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 1.5f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);
        document.close();
    }



}
