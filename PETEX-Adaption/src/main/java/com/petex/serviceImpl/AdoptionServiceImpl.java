package com.petex.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.DocumentException;
import com.petex.entity.AdoptionEntity;
import com.petex.entity.UserEntity;
import com.petex.repo.AdoptionRepo;
import com.petex.repo.UserRepo;
import com.petex.service.AdoptionService;
import com.petex.utils.EmailUtils;
import com.petex.utils.PdfGenerator;

@Service
public class AdoptionServiceImpl implements AdoptionService {

	@Autowired
	private AdoptionRepo repo;
	
	@Autowired
	private EmailUtils emailUtils;

	@Autowired
	private PdfGenerator pdfGenerator;

	@Autowired
	private UserRepo userRepo;

	

	@Override
	public List<AdoptionEntity> getAllAdoptions() {
		return repo.findAll();
	}

	@Override
	public Boolean create(AdoptionEntity entity, Long userId) throws DocumentException, IOException {
		Optional<UserEntity> optinalId = userRepo.findById(userId);

		if (optinalId.isPresent()) {
			UserEntity user = optinalId.get();
			entity.setUser(user);
			AdoptionEntity save = repo.save(entity);

			File f = new File("Adoption.pdf");
			pdfGenerator.generate(save, f);

			String subject = "Adoption Booking Report";
			String body = "Adoption";
			String to = user.getEmail();

			emailUtils.sendEmail(subject, body, to, f);
			f.delete();
			return true;
		}
		return false;
	}

}
