package com.DayCare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.DayCare.entity.DayCareEntity;



public interface DayCareService {
	 List<DayCareEntity> getAllServices();

	    Optional<DayCareEntity> getServiceById(Long daycareId);
	    	
	    public void savePetToDB(Long vendorId, MultipartFile file, double serviceCost,  String serviceType,String petType, String location, String description);
	    
	    void deleteServiceById(Long id);

	    DayCareEntity updateService(Long id,DayCareEntity updatedService);
	    public List<DayCareEntity> findByServiceTypeAndVendorId(String serviceType, Long vendorId);
	    
//	    List<DayCareEntity> getServicesByVendorId(Long vendorId);
	    
	    public List<DayCareEntity> findByServiceType(String serviceType);
	    
	    public List<DayCareEntity> findByServiceTypeAndLocation(String serviceType, String location);

}
