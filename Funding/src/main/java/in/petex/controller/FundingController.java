package in.petex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.petex.entity.FundingEntity;
import in.petex.service.FundingService;
import in.petex.utils.EmailUtils;
import in.petex.utils.PdfGenerator;
import jakarta.servlet.http.HttpServletResponse;


@RestController
@CrossOrigin("*")
@RequestMapping("/petex")
public class FundingController {
	
	@Autowired
	private FundingService service;
	
	
	
	
	
	
	
	@PostMapping("/api/funding")
	public ResponseEntity<String> saveReport(@RequestBody FundingEntity entity) {
	    String message;

	    try {
	        message = service.saveReport(entity);
	    } catch (IllegalArgumentException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }

	    return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/generateAndSendPdf")
	public ResponseEntity<String> pdfExport(HttpServletResponse response) throws Exception {

		response.setContentType("application/pdf");
		String headerkey = "content-disposition";
		String headerValue = "attchement;filename=report.pdf";
		response.addHeader(headerkey, headerValue);
		boolean status = service.exportPdf(response);

		if (status) {
			return new ResponseEntity<String>("pdf has sent in your mail", HttpStatus.OK);
		}
		return new ResponseEntity<String>("pdf has not sent in your mail", HttpStatus.OK);

	}


}
