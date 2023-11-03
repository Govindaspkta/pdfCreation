//package com.pdfgen.Controller;
//
//public class PdfController {
//
//}
package com.pdfgen.Controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PdfController {

    @GetMapping("/pdfgeneration")
    public void generatePdf(jakarta.servlet.http.HttpServletResponse response) throws IOException, DocumentException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=generatedpdf.pdf");

        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        document.add(new Paragraph("Generated PDF"));
        document.add(new Paragraph("This PDF is generated using Spring Boot and iText"));
        document.close();
    
    PdfPTable table = new PdfPTable(2);
    table.setWidthPercentage(100);
    table.addCell("Name");
    table.addCell("Age");
    table.addCell("Govinda Sapkota");
    table.addCell("22");
    table.addCell("Aashish Sapkota");
    table.addCell("22");
    document.add(table);

    document.close();
}
}
