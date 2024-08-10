package com.petshow.utils;

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
	import com.lowagie.text.pdf.PdfWriter;
import com.petshow.entity.PetshowEntity;

		@Component
		public class PdfGenerator {

			public void generate( PetshowEntity petshow, File f)
					throws DocumentException, IOException {

				Document document = new Document(PageSize.A4);
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(f));
				document.open();

				Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
				fontTitle.setSize(20);

				Paragraph paragraph = new Paragraph("Day Care Details", fontTitle);
				paragraph.setAlignment(Paragraph.ALIGN_CENTER);
				document.add(paragraph);

				document.add(new Paragraph("PetName: " + petshow.getPetName()));
				document.add(new Paragraph("PetBreed: " + petshow.getPetBreed()));
				document.add(new Paragraph("Email: " + petshow.getEmail()));
				document.add(new Paragraph("Mobile: " + petshow.getMobile()));				
				
		
				document.close();
				writer.close();

			}

			public static byte[] generatePDFReport(List<PetshowEntity> petshows) {

				return null;
			}

		}



