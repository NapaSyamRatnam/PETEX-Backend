package com.DayCare.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DayCare.entity.DayCareEntity;

@Repository
public interface DayCareRepo extends JpaRepository<DayCareEntity, Long> {
	
	 List<DayCareEntity> findByServiceTypeAndVendor_VendorId(String serviceType, Long vendorId);
    
//    List<DayCareEntity> findByVendorVendorId(Long vendorId);
	 
	 List<DayCareEntity> findByServiceType(String serviceType);
	 List<DayCareEntity> findByServiceTypeAndLocation(String serviceType, String location);
}

