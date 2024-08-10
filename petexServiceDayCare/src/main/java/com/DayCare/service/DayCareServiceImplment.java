package com.DayCare.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.DayCare.entity.DayCareEntity;
import com.DayCare.entity.VendorEntity;
import com.DayCare.repo.DayCareRepo;
import com.DayCare.repo.VendorRepository;

@Service
public class DayCareServiceImplment implements DayCareService {
	@Autowired
	private  DayCareRepo serviceRepository;
	
	@Autowired
	private VendorRepository vendorRepo;
	
	@Override
	public List<DayCareEntity> getAllServices() {
		 return serviceRepository.findAll();
	}

	
	
	@Override
	public Optional<DayCareEntity> getServiceById(Long daycareId) {
		  return serviceRepository.findById(daycareId);
	}

	@Override
	public void deleteServiceById(Long id) {
		serviceRepository.deleteById(id);
	}

	@Override
	public DayCareEntity updateService(Long id, DayCareEntity updatedService) {
		if (serviceRepository.existsById(id)) {
            updatedService.setDaycareId(id);;
            return serviceRepository.save(updatedService);
        }
        return null;
	}


	@Override
	public void savePetToDB(Long vendorId, MultipartFile file, double serviceCost, String serviceType,String petType,  String location, String description) {
	    VendorEntity vendor = vendorRepo.findById(vendorId)
	            .orElseThrow(() -> new IllegalArgumentException("Vendor with ID " + vendorId + " not found"));
	    
	    if (file == null || file.isEmpty() || location == null || location.isEmpty() || serviceCost <= 0) {
	        throw new IllegalArgumentException("Invalid Pet data");
	    }

	    try {
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	        if (fileName.contains("..")) {
	            throw new IllegalArgumentException("Invalid file name");
	        }
	        DayCareEntity pet = new DayCareEntity();
	        pet.setServiceCost(serviceCost);
	        pet.setServiceType(serviceType);
	        pet.setPetType(petType);
	        pet.setLocation(location);
	        pet.setDescription(description);
	        pet.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
	        pet.setVendor(vendor);
	        
	        serviceRepository.save(pet);
	    } catch (IOException e) {
	        throw new RuntimeException("Failed to save product", e);
	    }
	}
	
	  @Override
	    public List<DayCareEntity> findByServiceTypeAndVendorId(String serviceType, Long vendorId) {
	        return serviceRepository.findByServiceTypeAndVendor_VendorId(serviceType, vendorId);
	    }
	
//    @Override
//    public List<DayCareEntity> getServicesByVendorId(Long vendorId) {
//        return serviceRepository.findByVendorVendorId(vendorId);
//    }
	  
	  public List<DayCareEntity> findByServiceType(String serviceType) {
	        return serviceRepository.findByServiceType(serviceType);
	    }

	    public List<DayCareEntity> findByServiceTypeAndLocation(String serviceType, String location) {
	        return serviceRepository.findByServiceTypeAndLocation(serviceType, location);
	    }

}
