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

import in.saffu.entity.PurchaseEntity;

@Component
public class PurchasePdfGenerator {

	public void generate( PurchaseEntity purchase, File f)
			throws DocumentException, IOException {

		Document document = new Document(PageSize.A4);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();

		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);

		Paragraph paragraph = new Paragraph("Purchase Details", fontTitle);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);

		document.add(new Paragraph("Name: " + purchase.getPetname()));
		document.add(new Paragraph("Type: " + purchase.getPetType()));
		document.add(new Paragraph("Gender: " + purchase.getGender()));
		document.add(new Paragraph("Email: " + purchase.getEmail()));
		document.add(new Paragraph("Height: " + purchase.getHeight()));
		document.add(new Paragraph("Mobile: " + purchase.getPhno()));
		document.add(new Paragraph("Color: " + purchase.getColor()));
		document.add(new Paragraph("Address: " + purchase.getAddress()));
		document.add(new Paragraph("weight: " + purchase.getWeight()));
		
		document.close();
		writer.close();

	}

}
