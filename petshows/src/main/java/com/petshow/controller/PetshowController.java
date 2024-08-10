package com.petshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshow.entity.AdminshowEntity;
import com.petshow.entity.PetshowEntity;
import com.petshow.service.PetShowService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/Petshow")
public class PetshowController {

	@Autowired
	private PetShowService petShowService;

	@PostMapping("save/{userId}")
	public ResponseEntity<String> savePetshow(@RequestBody PetshowEntity entity, @PathVariable Long userId) {
		try {
			Boolean status = petShowService.savePetshow(entity, userId);
			if (status) {
				return new ResponseEntity<>("Petshow data saved successfully", HttpStatus.CREATED);
			}
			return new ResponseEntity<>("PetShow data not saved successfully", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to save Petshow data", HttpStatus.BAD_REQUEST);
		}
	}
	

	@GetMapping("/petshow/report")
	public ResponseEntity<Resource> generatePDFReport() {
		byte[] pdfBytes = petShowService.generatePDFReport();
		ByteArrayResource resource = new ByteArrayResource(pdfBytes);
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=petshows_report.pdf");
		return ResponseEntity.ok().headers(headers).contentLength(pdfBytes.length)
				.contentType(MediaType.APPLICATION_PDF).body(resource);
	}
	
	@GetMapping("/getAll")
	public List<PetshowEntity> getAllBookings() {
		return petShowService.getAllBookings();
	}
}
