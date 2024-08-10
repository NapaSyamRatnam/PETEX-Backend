package in.saffu.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import in.saffu.entity.SalesEntity;

@Component
public class SalesPdfGenerator {

	public void generate( SalesEntity sales, File f)
			throws DocumentException, IOException {

		Document document = new Document(PageSize.A4);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();

		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);

		Paragraph paragraph = new Paragraph("Sales Details", fontTitle);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);

		document.add(new Paragraph("Name: " + sales.getPetname()));
		document.add(new Paragraph("Type: " + sales.getPetType()));
		document.add(new Paragraph("Gender: " + sales.getGender()));
		document.add(new Paragraph("Email: " + sales.getEmail()));
		document.add(new Paragraph("Height: " + sales.getHeight()));
		document.add(new Paragraph("Mobile: " + sales.getPhno()));
		document.add(new Paragraph("Color: " + sales.getColor()));
		document.add(new Paragraph("Address: " + sales.getAddress()));
		document.add(new Paragraph("weight: " + sales.getWeight()));
		
		document.close();
		writer.close();

	}

}
