package com.petex.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.petex.entity.ReportEntity;
import com.petex.services.ReportServices;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin("*")
@RequestMapping("/petex")
public class ReportRestController {

	@Autowired
	private ReportServices services;

	@PostMapping("/save")
	public ResponseEntity<String> savePetReport(
	        @RequestParam("image") MultipartFile image,
	        @RequestParam("petOwnerName") String petOwnerName,
	        @RequestParam("email") String email,
	        @RequestParam("mobileNumber") String mobileNumber,
	        @RequestParam("petName") String petName,
	        @RequestParam("petType") String petType,
	        @RequestParam("petBreed") String petBreed,
	        @RequestParam("petAge") int petAge,
	        @RequestParam("petExpensesPerMonth") double petExpensesPerMonth,
	        @RequestParam("reasonForFunding") String reasonForFunding,
	        @RequestParam("donationAmount") double donationAmount
	) throws IOException {
	    ReportEntity petReport = new ReportEntity();
	   
	    petReport.setPetOwnerName(petOwnerName);
	    petReport.setEmail(email);
	    petReport.setMobileNumber(mobileNumber);
	    petReport.setPetName(petName);
	    petReport.setPetType(petType);
	    petReport.setPetBreed(petBreed);
	    petReport.setPetAge(petAge);
	    petReport.setPetExpensesPerMonth(petExpensesPerMonth);
	    petReport.setReasonForFunding(reasonForFunding);
	    petReport.setDonationAmount(donationAmount);
	    
	    String result = services.saveReport(petReport, image);
	    if (result.startsWith("Error occurred")) {
	        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	    } else {
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    }
	}

	@GetMapping("/getAllReport")
	public ResponseEntity<List<ReportEntity>> getAllReportData() {
		List<ReportEntity> allReport = services.getAllReport();
		return new ResponseEntity<List<ReportEntity>>(allReport, HttpStatus.OK);
	}

	@GetMapping("/generateAndSendPdf")
	public ResponseEntity<String> pdfExport(HttpServletResponse response) throws Exception {

		response.setContentType("application/pdf");
		String headerkey = "content-disposition";
		String headerValue = "attchement;filename=report.pdf";
		response.addHeader(headerkey, headerValue);
		boolean status = services.exportPdf(response);

		if (status) {
			return new ResponseEntity<String>("pdf has sent in your mail", HttpStatus.OK);
		}
		return new ResponseEntity<String>("pdf has not sent in your mail", HttpStatus.OK);

	}

}
