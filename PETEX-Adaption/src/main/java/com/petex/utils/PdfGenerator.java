package com.petex.utils;

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
import com.petex.entity.AdoptionEntity;

@Component
public class PdfGenerator {

	public void generate( AdoptionEntity adoption, File f)
			throws DocumentException, IOException {

		Document document = new Document(PageSize.A4);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();

		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);

		Paragraph paragraph = new Paragraph("Adoption Details", fontTitle);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);

		document.add(new Paragraph("User Name: " + adoption.getUserName()));
		document.add(new Paragraph("Occuption: " + adoption.getOccuption()));
		document.add(new Paragraph("Email: " + adoption.getEmailaddress()));
		document.add(new Paragraph("Age: " + adoption.getAge()));
		document.add(new Paragraph("City: " + adoption.getCity()));
		document.add(new Paragraph("Mobile: " + adoption.getContactNumber()));
		document.add(new Paragraph("Pet name: " + adoption.getPetname()));
		
		document.close();
		writer.close();

	}

}
