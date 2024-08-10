package com.petshow.service;

import java.io.IOException;
import java.util.List;

import com.petshow.entity.PetshowEntity;

public interface PetShowService  {

	
	 Boolean savePetshow( PetshowEntity entity, Long userId ) throws  IOException;

	  byte[] generatePDFReport();

	List<PetshowEntity> getAllBookings();

	




	

}
