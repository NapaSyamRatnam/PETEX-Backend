package com.slotBooking.utils;

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
import com.slotBooking.entity.Appointment;

@Component
public class PdfGenerator {

	public void generate( Appointment appointment, File f)
			throws DocumentException, IOException {

		Document document = new Document(PageSize.A4);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();

		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);

		Paragraph paragraph = new Paragraph("Appointment Details", fontTitle);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);

		document.add(new Paragraph("Date: " + appointment.getBookingDate()));
		document.add(new Paragraph("Time: " + appointment.getBookingTime()));
		document.add(new Paragraph("Pet Name: " + appointment.getPetName()));
		document.add(new Paragraph("Pet Breed: " + appointment.getPetBreed()));
		document.add(new Paragraph("Pet Description: " + appointment.getPetDescription()));
		document.add(new Paragraph("User Email: " + appointment.getUserEmail()));
		document.add(new Paragraph("User Mobile Number: " + appointment.getUserMobileNumber()));
		document.add(new Paragraph("Type of Service: " + appointment.getTypeOfService()));

		document.close();
		writer.close();

	}

}
