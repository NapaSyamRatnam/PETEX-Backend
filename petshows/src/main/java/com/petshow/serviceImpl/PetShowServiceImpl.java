package com.petshow.serviceImpl;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshow.entity.AdminSingUpEntity;
import com.petshow.entity.AdminshowEntity;
import com.petshow.entity.PetshowEntity;
import com.petshow.entity.UserEntity;
import com.petshow.repo.AdminloginRepository;
import com.petshow.repo.PetshowRepo;
import com.petshow.repo.UserRepository;
import com.petshow.service.PetShowService;
import com.petshow.utils.PdfGenerator;


@Service
public class PetShowServiceImpl implements PetShowService {

    @Autowired
    private PetshowRepo petshowRepo;
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private AdminloginRepository adminRepo;
    
    
	
    @Override
	public Boolean savePetshow(PetshowEntity entity, Long userId) throws IOException {
    	
    	Optional<UserEntity> optinalUserId = userRepo.findById(userId);    	
    	if (optinalUserId.isPresent()) {
    		UserEntity user = optinalUserId.get();
    		
    		entity.setUser(user);
    		
    		petshowRepo.save(entity);
    		return true;
			
		}
		
		return false;
	}
   

    @Override
    public byte[] generatePDFReport() {
        List<PetshowEntity> petshows = petshowRepo.findAll();
        return PdfGenerator.generatePDFReport(petshows);
    }
	
    @Override
	public List<PetshowEntity> getAllBookings() {
		return petshowRepo.findAll();
	}

	
}
