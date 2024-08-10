package com.petex.rest;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.petex.binding.LoginForm;
import com.petex.binding.NewConfirmPwdForm;
import com.petex.binding.OtpForm;
import com.petex.entity.UserEntity;
import com.petex.service.UserService;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api/users")
public class UserRestController {

	@Autowired
	private UserService services;

//	@PostMapping("/signup")
//	public ResponseEntity<String> saveUser(@RequestBody UserSingUpForm form) {
//		String singUpUser = services.singUpUser(form);
//		return new ResponseEntity<>(singUpUser, HttpStatus.CREATED);
//	}

	@PostMapping("/signup")
	public ResponseEntity<String> saveUser(@RequestParam("petType") String petType,
			@RequestParam("petname") String petname, @RequestParam("species") String species,
			@RequestParam("age") Integer age, @RequestParam("gender") String gender,
			@RequestParam("weight") Double weight, @RequestParam("height") Double height,
			@RequestParam("color") String color, @RequestParam("disease") String disease,
			@RequestParam("vaccinated") String vaccinated, @RequestParam("fullname") String fullname,
			@RequestParam("email") String email, @RequestParam("pwd") String pwd,
			@RequestParam("confirmPwd") String confirmPwd, @RequestParam("phno") Long phno,
			@RequestParam("city") String city, @RequestParam("image") MultipartFile image
//	                                       @RequestParam("otp") String otp
	) {
		try {
			// Create a new UserEntity object
			UserEntity userEntity = new UserEntity();

			// Set the properties of the UserEntity object using the parameters
			userEntity.setPetType(petType);
			userEntity.setPetname(petname);
			userEntity.setSpecies(species);
			userEntity.setAge(age);
			userEntity.setGender(gender);
			userEntity.setWeight(weight);
			userEntity.setHeight(height);
			userEntity.setColor(color);
			userEntity.setDisease(disease);
			userEntity.setVaccinated(vaccinated);
			userEntity.setFullname(fullname);
			userEntity.setEmail(email);
			userEntity.setPwd(pwd);
			userEntity.setConfirmPwd(confirmPwd);
			userEntity.setPhno(phno);
			userEntity.setCity(city);
			userEntity.setImage(image.getBytes()); // Convert MultipartFile to byte array
//	        userEntity.setOtp(otp);

			// Call the service method to save the user
			String signUpUser = services.singUpUser(userEntity);

			// Return response entity with appropriate status and message
			return new ResponseEntity<>(signUpUser, HttpStatus.CREATED);
		} catch (IOException e) {
			// Handle IOException if occurred (e.g., failed to convert MultipartFile to byte
			// array)
			e.printStackTrace(); // You can log the error for debugging
			return new ResponseEntity<>("Failed to process the image file", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody LoginForm form) {
		String login = services.login(form);
		if (login.equals("login success")) {
			return new ResponseEntity<>(login, HttpStatus.OK);
		}
		return new ResponseEntity<>(login, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/forget/{email}")
	public ResponseEntity<String> GerateUserOtp(@PathVariable String email) {
		Boolean status = services.forgetPwd(email);
		if (status) {
			return new ResponseEntity<String>("An otp has been sent to your email", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Email not found,Give Exist Email", HttpStatus.NOT_FOUND);
	}

	@PostMapping("/validotp")
	public ResponseEntity<String> validOtp(@RequestBody OtpForm form) {
		String isValid = services.validOtp(form);
		if (isValid.equals("otp confirmed")) {
			return ResponseEntity.ok("OTP verified");
		} else {
			return ResponseEntity.badRequest().body("Invalid OTP");
		}
	}

	@PostMapping("/confirmpwd")
	public ResponseEntity<String> confirmPassword(@RequestBody NewConfirmPwdForm form) {
		String confirmPassword = services.confirmPassword(form);
		return new ResponseEntity<String>(confirmPassword, HttpStatus.OK);

	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody UserEntity entity) {
		Boolean status = services.updateUser(userId, entity);
		if (status) {
			return new ResponseEntity<String>("Update successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("update not succesfull", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
		Boolean deleteUser = services.deleteUser(userId);
		if (deleteUser) {
			return new ResponseEntity<String>("delete successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("delete not happend successfully", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getAlluser")
	public ResponseEntity<List<UserEntity>> gertAllUser() {
		List<UserEntity> allUser = services.getAllUser();
		return new ResponseEntity<List<UserEntity>>(allUser, HttpStatus.OK);
	}

	@GetMapping("/getuser/{userId}")
	public ResponseEntity<UserEntity> getById(@PathVariable Long userId) {
		UserEntity userEntity = services.getById(userId);
		return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
	}


	@GetMapping("/getimage/{userId}")
	public ResponseEntity<String> getbyimage(@PathVariable Long userId) {
	    UserEntity userEntity = services.getById(userId);
	    
	    if (userEntity == null || userEntity.getImage() == null) {
	        return new ResponseEntity<>("Image not found", HttpStatus.NOT_FOUND);
	    }

	    String imageData = Base64.getEncoder().encodeToString(userEntity.getImage());
	    
	    return new ResponseEntity<>(imageData, HttpStatus.OK);
	}

	@GetMapping("/getByEmail/{email}")
	public ResponseEntity<UserEntity> getUserByEmail(@PathVariable String email) {
		UserEntity user = services.getUserByEmail(email);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
}
