package com.Petex.Api.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Petex.Api.Entity.ContactUsentity;
import com.Petex.Api.Repo.ContactUsRepository;



@RestController
@RequestMapping("/petex")
@CrossOrigin(origins = "*")
public class ContactUsController {

	@Autowired
	private ContactUsRepository contactrepository;
	
	@PostMapping("/contactus")
	public ResponseEntity<ContactUsentity> saveContact(@RequestBody ContactUsentity contact){
		return new ResponseEntity<>(contactrepository.save(contact),HttpStatus.CREATED);
	}
}
