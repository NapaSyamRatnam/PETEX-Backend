package com.petex.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petex.entity.CommentsEntity;
import com.petex.service.CommentsService;

@RestController
@RequestMapping("/petex")
@CrossOrigin(origins = "http://localhost:3000")
public class CommentsRestController {
	
	@Autowired
	private CommentsService services;
	
	@PostMapping("/save/{userId}")
	public ResponseEntity<String> savePetexComments(@RequestBody CommentsEntity entity, @PathVariable Long userId) {
		System.out.println(entity.getmessage());
		Boolean status = services.saveCommnet(entity, userId);
		if (status) {
			return new ResponseEntity<>("PetexComments saved successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("PetexComments not saved successfully", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<CommentsEntity>> getAllUsers() {
		List<CommentsEntity> allUsers = services.getAllUser();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}
	
	@GetMapping("/message/{userId}")
	public CommentsEntity getUserById(@PathVariable("userId") Long userId) {
		return services.getUserById(userId);
	}
	
	@DeleteMapping("/deluser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable long id) {
		String deleteUser = services.deleteUser(id);
		return new ResponseEntity<>(deleteUser, HttpStatus.OK);
	}
}
