package com.doctsighn.restcontroller;

import java.io.IOException;


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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.doctsighn.binding.DoctorSingUp;
import com.doctsighn.binding.LoginForm;
import com.doctsighn.binding.NewConfirmPwdForm;
import com.doctsighn.binding.OtpForm;
import com.doctsighn.entity.DoctorEntity;
import com.doctsighn.repository.DoctorSinghUpRepo;
import com.doctsighn.service.DoctorSingUpService;

@CrossOrigin("http://localhost:3000")
@RequestMapping("/petex")
@RestController
public class DoctorSingUpController {

	@Autowired
	private DoctorSingUpService service;
	
	@Autowired
	private DoctorSinghUpRepo doctorrepo;


//	@GetMapping("/getId/{doctId}")
//
//	public ResponseEntity<DoctorEntity> getDoctorid(@PathVariable Long doctId) {
//		DoctorEntity doctorid = service.getDoctorid(doctId);
//		return new ResponseEntity<>(doctorid, HttpStatus.OK);
//	}

	 @PostMapping("/save")
	    public ResponseEntity<String> saveDoctor(
	            @RequestParam("image") MultipartFile image,
	            @RequestParam("doctorName") String doctorName,
	            @RequestParam("qualificationAndSpecialization") String qualificationAndSpecialization,
	            @RequestParam("overAllExperience") String overAllExperience,
	            @RequestParam("mobileNumber") String mobileNumber,
	            @RequestParam("email") String email,
	            @RequestParam("pwd") String pwd,
	            @RequestParam("confirmPassword") String confirmPassword,
	            @RequestParam("registrationBody") String registrationBody,
	            @RequestParam("medicalBoard") String medicalBoard,
	            @RequestParam("discription") String discription,
	            @RequestParam("clinicName") String clinicName,
	            @RequestParam("location") String location
	           
//	            @RequestParam("otp") String otp
	            
	            
	    ) throws IOException {
	        DoctorSingUp doctorSignUp = new DoctorSingUp();
	       
	        doctorSignUp.setDoctorName(doctorName);
	        doctorSignUp.setQualificationAndSpecialization(qualificationAndSpecialization);
	        doctorSignUp.setOverAllExperience(overAllExperience);
	        doctorSignUp.setMobileNumber(mobileNumber);
	        doctorSignUp.setEmail(email);
	        doctorSignUp.setPwd(pwd);
	        doctorSignUp.setConfirmPassword(confirmPassword);
	        doctorSignUp.setRegistrationBody(registrationBody);
	        doctorSignUp.setMedicalBoard(medicalBoard);
	        doctorSignUp.setDiscription(discription);
	        doctorSignUp.setClinicName(clinicName);
	        doctorSignUp.setLocation(location);
	        
	       
//	        OtpForm otpForm = new OtpForm();
//			otpForm.setOtp(otp);
			

	        String result = service.saveDocter(doctorSignUp, image);
	        if (result.startsWith("Error occurred")) {
	            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	        } else if (result.startsWith("Email already exists")) {
	            return new ResponseEntity<>(result, HttpStatus.CONFLICT);
	        } else {
	            return new ResponseEntity<>(result, HttpStatus.OK);
	        }
	    }


	
    @GetMapping("/doctor/{doctId}")
    public ResponseEntity<?> getDoctorById(@PathVariable Long doctId) {
        DoctorEntity doctor = service.getDoctorById(doctId);
        if (doctor != null) {
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Doctor not found", HttpStatus.NOT_FOUND);
        }
    }
	
	@GetMapping("/getAll")
	public List<DoctorEntity> getAllDoctor() {
		List<DoctorEntity> allDoctor = service.getAllDoctor();
		return allDoctor;
	}

	@DeleteMapping("/deleteId/{doctId}")
	public ResponseEntity<String> deleteRecord(@PathVariable long doctId) {
		String deleteRecord = service.deleteRecord(doctId);
		return new ResponseEntity<>(deleteRecord, HttpStatus.OK);
	}

	@PutMapping("/update/{doctId}")
	public ResponseEntity<String> updateDoctorRecord(@PathVariable Long doctId, @RequestBody DoctorSingUp form) {
		Boolean status = service.updateDoctorRecord(doctId, form);
		if (status) {
			return new ResponseEntity<>("update suiccessfully", HttpStatus.OK);

		}
		return new ResponseEntity<>("update not  suiccessfully", HttpStatus.OK);
	}

//	@PostMapping("/login")
//	public ResponseEntity<String> login(@RequestBody LoginForm form) {
//		String login = service.login(form);
//		if (login.equals("login success")) {
//			return new ResponseEntity<>(login, HttpStatus.OK);
//		}
//		return new ResponseEntity<>(login, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	
	
    @PostMapping("/login")
    public DoctorEntity loginUser(@RequestBody DoctorEntity doctorData) {
        String email = doctorData.getEmail();
        String pwd = doctorData.getPassword();
        DoctorEntity user = doctorrepo.findByEmailAndPwd(email, pwd);

        return user;
    }

	@GetMapping("/forget/{email}")
	public ResponseEntity<String> forgetPwd(@PathVariable String email) {
		Boolean forgetPwd = service.forgetPwd(email);
		if (forgetPwd) {
			return new ResponseEntity<String>("otp will send ur mail", HttpStatus.OK);
		}
		return new ResponseEntity<String>("email not found give me exits ", HttpStatus.NOT_FOUND);
	}

	@PostMapping("/validotp")
	public ResponseEntity<String> validOtp(@RequestBody OtpForm form) {
		String validOtp = service.validOtp(form);
		return new ResponseEntity<>(validOtp, HttpStatus.OK);
	}

	@PostMapping("/confirmPassword")

	public ResponseEntity<String> confirmPassword(@RequestBody NewConfirmPwdForm form) {
		String confirmPassword = service.confirmPassword(form);
		return new ResponseEntity<>(confirmPassword, HttpStatus.OK);
	}
	

	@GetMapping("/doctors/{doctorName}")
	
	public List<DoctorEntity> searchDoctorsByName(@PathVariable String doctorName) {
	    return service.findDoctorsByName(doctorName);
	}
	
	@GetMapping("/doctors/location/{location}")
	public ResponseEntity<List<DoctorEntity>> searchDoctorsByLocation(@PathVariable String location) {
	    List<DoctorEntity> doctors = service.findDoctorsByLocation(location);
	    if (doctors.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(doctors, HttpStatus.OK);
	}
	
    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<DoctorEntity> getUserByEmail(@PathVariable String email) {
        DoctorEntity user = service.getdoctorByEmail(email);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/{doctId}")
    public DoctorEntity getTestReportById(@PathVariable("doctId") Long doctId) {
        return service.getTestReportById(doctId);
    }

}