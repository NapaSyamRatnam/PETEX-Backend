package com.doctsighn.serviceImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.doctsighn.binding.DoctorSingUp;
import com.doctsighn.binding.LoginForm;
import com.doctsighn.binding.NewConfirmPwdForm;
import com.doctsighn.binding.OtpForm;
import com.doctsighn.entity.DoctorEntity;
import com.doctsighn.repository.DoctorSinghUpRepo;
import com.doctsighn.service.DoctorSingUpService;
import com.doctsighn.utils.EmailUtils;
import com.doctsighn.utils.PasswordUtils;


@Service
public class DoctorSighnUpServiceImpl implements DoctorSingUpService {

	@Autowired
	private DoctorSinghUpRepo repo;

	@Autowired
	private EmailUtils emailUtils;
	
    @Override
    public DoctorEntity findByEmailAndPwd(String email, String pwd) {
        return repo.findByEmailAndPwd(email, pwd);
    }

    @Override
    public String saveDocter(DoctorSingUp form, MultipartFile image) {
        try {
            if (form.getPwd().equals(form.getConfirmPassword())) {
                if (!repo.existsByEmail(form.getEmail())) {
                    DoctorEntity entity = new DoctorEntity();
                    BeanUtils.copyProperties(form, entity);

                    // Handle image saving
                    if (image != null && !image.isEmpty()) {
                        byte[] imageData = image.getBytes();
                        entity.setImage(imageData);
                    }

                    repo.save(entity);
                    return "Signup successful";
                } else {
                    return "Email already exists. Please use a different email.";
                }
            }
            return "Invalid password and confirmation password";
        } catch (Exception e) {
            return "Error occurred while saving doctor: " + e.getMessage();
        }
    }


	@Override
	public DoctorEntity getDoctorById(Long doctId) {
		Optional<DoctorEntity> getbyId = repo.findById(doctId);
		if (getbyId.isPresent()) {

			return getbyId.get();
		}
		return null;
	}

	@Override
	public List<DoctorEntity> getAllDoctor() {
		List<DoctorEntity> getall = repo.findAll();
		return getall;
	}

	@Override
	public String deleteRecord(long doctId) {
		boolean existsById = repo.existsById(doctId);
		if (existsById) {
			repo.deleteById(doctId);
			return " id" + doctId + "is present";
		}
		return null;
	}

	@Override
	public Boolean updateDoctorRecord(Long doctId, DoctorSingUp form) {
		Optional<DoctorEntity> optinalId = repo.findById(doctId);
		if (optinalId.isPresent()) {
			DoctorEntity doctorEntity = optinalId.get();
			BeanUtils.copyProperties(form, doctorEntity);
			doctorEntity.setDoctId(doctId);
			repo.save(doctorEntity);
			return true;

		}
		return false;
	
	}

	///////////// login
	@Override
	public String login(LoginForm form) {
		DoctorEntity findBybyEmailAndPaw = repo.findByEmailAndPwd(form.getEmail(), form.getPassword());

		if (findBybyEmailAndPaw != null) {
			return "login success";

		}
		return "check pwd and email";

	}

/////forget password
	@Override
	public Boolean forgetPwd(String email) {
		DoctorEntity entity = repo.findByEmail(email);
		if (entity == null) {
			return false;
		}
		String toEmail = entity.getEmail();
		String otp = PasswordUtils.genrateRandomPassword();
		entity.setOtp(otp);
		repo.save(entity);
		String subject = "new otp";

		StringBuffer body = new StringBuffer("");
		body.append("take this temprory otp::" + otp);
		emailUtils.sendEmail(toEmail, subject, body.toString());
		return true;
	}

	////////////////// otp valid
	@Override
	public String validOtp(OtpForm form) {
		DoctorEntity byEmailAndOtp = repo.findByEmailAndOtp(form.getEmail(), form.getOtp());
		if (byEmailAndOtp != null) {
			return "otp confirmed";
		}
		return "otp and email mismatch";

	}

	@Override
	public String confirmPassword(NewConfirmPwdForm form) {
		DoctorEntity entity = repo.findByEmail(form.getEmail());
		if (entity != null) {
			if (form.getPassword().equals(form.getConfirmPwd())) {
				entity.setPassword(form.getPassword());
				entity.setConfirmPassword(form.getConfirmPwd());
				repo.save(entity);
				return "Your password has been successfully updated";
			} else {
				return "Password and confirmation password do not match";
			}
		}
		return "Failed to update password. Please check your current password and try again.";
	}


//	 @Override
//	    public DoctorEntity findByImage(byte[] image) {
//	        return repo.findByImage(image);
//	    }
//	
	 @Override
	    public List<DoctorEntity> findDoctorsByName(String doctorName) {
	        return repo.findByDoctorNameContaining(doctorName);
	    }
	 
	  @Override
	    public List<DoctorEntity> findDoctorsByLocation(String location) {
	        return repo.findByLocation(location);
	    }
	  
		@Override
		public DoctorEntity getdoctorByEmail(String email) {
			// TODO Auto-generated method stub
			return repo.findByEmail(email);
		}
	  
		@Override
		public DoctorEntity updateDoctorRecord(long doctId, DoctorEntity doctorsingh) {
			Optional<DoctorEntity> findbyId = repo.findById(doctId);
			if (findbyId.isEmpty()) {
				return null;

			}
			DoctorEntity doctorEntity = findbyId.get();
			doctorEntity.setDoctorName(doctorsingh.getDoctorName());
			doctorEntity.setQualificationAndSpecialization(doctorsingh.getQualificationAndSpecialization());
			doctorEntity.setOverAllExperience(doctorsingh.getOverAllExperience());
			doctorEntity.setMobileNumber(doctorsingh.getMobileNumber());
			doctorEntity.setEmail(doctorsingh.getEmail());
			doctorEntity.setPassword(doctorsingh.getPassword());
			doctorEntity.setConfirmPassword(doctorsingh.getConfirmPassword());
			doctorEntity.setRegistrationBody(doctorsingh.getRegistrationBody());
			doctorEntity.setMedicalBoard(doctorsingh.getMedicalBoard());
			doctorEntity.setDiscription(doctorsingh.getDiscription());
			doctorEntity.setClinicName(doctorsingh.getClinicName());

			DoctorEntity save = repo.save(doctorEntity);

			return save;
		}
		
		@Override
	    public DoctorEntity getTestReportById(Long doctId) {
	        Optional<DoctorEntity> optionalTestReport = repo.findById(doctId);
	        return optionalTestReport.orElse(null);
	    }

	   
}
