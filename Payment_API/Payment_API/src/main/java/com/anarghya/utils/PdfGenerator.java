package com.anarghya.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.anarghya.entity.Payment;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class PdfGenerator {

	public void generate(Payment payment, File f) throws DocumentException, IOException {

		Document document = new Document(PageSize.A4);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();

		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);

		Paragraph paragraph = new Paragraph("Acknowledgment Details", fontTitle);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);

		document.add(new Paragraph("Payment ID: " + payment.getPaymentId()));
		document.add(new Paragraph(
				"Petex Id: " + (payment.getOrder() != null ? payment.getOrder().getUser().getUserId() : "")));



		if (payment.getOrder() != null) {
			document.add(new Paragraph("Quantity: " + payment.getOrder().getQuantity()));
			document.add(new Paragraph("Total Price: " + payment.getOrder().getTotalPrice()));
		}

		document.add(new Paragraph("TransactionId: " + payment.getTransactionId()));

		document.close();
		writer.close();

	}

}
