package com.petex.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.petex.entity.AdoptionEntity;
import com.petex.service.AdoptionService;

@RestController
@RequestMapping("/petex")
@CrossOrigin(origins = "*")
public class AdoptionRestController {
	
	@Autowired
	private AdoptionService services;
	
	@PostMapping("/save/{userId}")
	public ResponseEntity<String> savePetexAdaption(@RequestBody AdoptionEntity entity,@PathVariable Long userId) throws DocumentException, IOException {

		Boolean status = services.create(entity, userId);
		if (status) {
			return new ResponseEntity<>("PetexAdaption successfully", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("PetexAdaption not  successfully", HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@GetMapping("/orders")
    public ResponseEntity<List<AdoptionEntity>> getAllAdoptions() {
        List<AdoptionEntity> adoptions = services.getAllAdoptions();
        return new ResponseEntity<>(adoptions, HttpStatus.OK);
    }

}
