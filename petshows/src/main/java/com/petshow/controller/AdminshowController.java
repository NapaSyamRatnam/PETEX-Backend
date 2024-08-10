package com.petshow.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lowagie.text.DocumentException;
import com.petshow.entity.AdminshowEntity;
import com.petshow.repo.AdminshowRepository;
import com.petshow.serviceImpl.AdminshowService;

@RestController
@CrossOrigin(origins = "*")
public class AdminshowController {

	@Autowired
	private AdminshowRepository adminRepo;

	@Autowired
	private AdminshowService adminshowservice;

	@GetMapping("/listProduct")
	public List<AdminshowEntity> listEventName() {
		return adminRepo.findAll();
	}

	@GetMapping("/categories")
	public List<String> getAllLocation(String location) {
		return adminshowservice.getAllLocation(location);
	}

	@GetMapping("/getAll")
	public List<AdminshowEntity> getAllProducts() {
		return adminshowservice.getAllProducts();
	}

	@GetMapping("/products/{category}")
	public List<AdminshowEntity> getProductsByCategory(@PathVariable String category) {
		return adminshowservice.getProductsByCategory(category);
	}

//	@PostMapping("/save/{adminId}")
//	public ResponseEntity<String> saveShows(@ModelAttribute AdminshowEntity entity, @PathVariable Long adminId,
//			@RequestParam(value = "imageFile", required = false) MultipartFile imageFile) {
//		try {
//			Boolean adminshowEntity = adminshowservice.AdminshowEntity(entity, adminId, imageFile);
//
//			if (adminshowEntity) {
//				return new ResponseEntity<>("Sales saved successfully", HttpStatus.CREATED);
//			} else {
//				return new ResponseEntity<>("Failed to save sales", HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//		} catch (DocumentException | IOException e) {
//			e.printStackTrace();
//			return new ResponseEntity<>("Failed to save sales", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
	 @PostMapping("/save/{adminId}")
	    public ResponseEntity<String> saveAdminShow(@RequestParam("eventname") String eventName,
	            @RequestParam("location") String location, @RequestParam("price") int price,
	            @RequestParam("date") String dateStr, @RequestParam("time") String timeStr,
	            @RequestParam("image") MultipartFile image, @PathVariable Long adminId) {
	        try {
	            // Parse date and time from string representations
	            LocalDate date = LocalDate.parse(dateStr);
	            LocalTime time = LocalTime.parse(timeStr);

	            // Create AdminshowEntity object
	            AdminshowEntity adminshow = new AdminshowEntity();
	            adminshow.setEventname(eventName);
	            adminshow.setLocation(location);
	            adminshow.setPrice(price);
	            adminshow.setDate(date);
	            adminshow.setTime(time);

	            // Save AdminshowEntity with image
	            boolean saved = adminshowservice.saveAdminShow(adminshow, adminId, image);
	            if (saved) {
	                return ResponseEntity.status(HttpStatus.CREATED).body("Admin show saved successfully");
	            } else {
	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save admin show");
	            }
	        } catch (IOException | DocumentException e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save admin show");
	        }
	    }

	@DeleteMapping("/products/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") Integer productId) {
		try {
			adminshowservice.deleteProductById(productId);
			return ResponseEntity.ok().body("Product deleted successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error deleting product: " + e.getMessage());
		}
	}
	
	

}
