package in.petex.utils;

import java.io.File;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.petex.entity.FundingEntity;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {

    public void generate(HttpServletResponse response, List<FundingEntity> entities, File f)
            throws DocumentException, IOException {

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        PdfWriter.getInstance(document, new FileOutputStream(f));
        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTitle.setSize(20);

        Paragraph paragraph = new Paragraph("PETEX FUNDING", fontTitle);

        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(paragraph);

        PdfPTable table = new PdfPTable(11); // Adjust the number of columns based on your entity fields
        table.setWidthPercentage(100f);
        table.setWidths(new float[] { 1.5f, 3.5f, 3.5f, 2.5f, 2.5f, 2.5f, 2.5f, 3.5f, 3.5f, 3.5f, 3.5f });
        table.setSpacingBefore(5);

        table.addCell("DonorId");
        table.addCell("DonorName");
        table.addCell("Email");
        table.addCell("MobileNumber");
        table.addCell("PetName");
       
        
        table.addCell("ReasonForFunding");
        table.addCell("DonationAmount");

        for (FundingEntity entity : entities) {
            table.addCell(String.valueOf(entity.getDonorId()));
            table.addCell(entity.getDonorName());
            table.addCell(entity.getEmail());
            table.addCell(entity.getMobileNumber());
            table.addCell(entity.getPetName());
           
            table.addCell(entity.getReasonForFunding());
            table.addCell(String.valueOf(entity.getDonationAmount()));
        }

        document.add(table);
        document.close();
    }
}
