package com.petex.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.petex.entity.ReportEntity;
import com.petex.repository.ReportRepository;
import com.petex.services.ReportServices;
import com.petex.utils.EmailUtils;
import com.petex.utils.PdfGenerator;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServicesImpl implements ReportServices {

	@Autowired
	private ReportRepository repo;

	@Autowired
	private EmailUtils emailUtils;

	@Autowired
	private PdfGenerator pdfGenrator;

	@Override
	public String saveReport(ReportEntity entity, MultipartFile image) {
	    try {
	        // Handle image saving
	        if (image != null && !image.isEmpty()) {
	            byte[] imageData = image.getBytes();
	            entity.setImage(imageData);
	        }

	        repo.save(entity);
	        return "Report saved successfully";
	    } catch (IOException e) {
	        return "Error occurred while saving report: " + e.getMessage();
	    }
	}


	@Override
	public List<ReportEntity> getAllReport() {
		return repo.findAll();

	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		List<ReportEntity> report = repo.findAll();

		if (report.isEmpty()) {
			throw new Exception("No data found");
		}

		File f = new File("report.pdf");

		pdfGenrator.generate(response, report, f);
		String subject = "PET FUNDING";
		String body = "PET BODY";
		String to = "srikanthvk0@gmail.com";

		emailUtils.sendEmail(subject, body, to, f);
		f.delete();
		return true;
	}

}
