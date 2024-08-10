package com.petex.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petex.entity.AdoptionEntity;
import com.petex.service.AdoptionService;

@RestController
@RequestMapping("/petex")
@CrossOrigin("*")
public class AdoptionRestController {
	
	@Autowired
	private AdoptionService services;
	
	@PostMapping("/save")
	public ResponseEntity<String> savePetexAdaption(@RequestBody AdoptionEntity entity) {

		Boolean status = services.saveAdtion(entity);
		if (status) {
			return new ResponseEntity<>("PetexAdaption successfully", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("PetexAdaption not  successfully", HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
