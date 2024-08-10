package com.petex.service;

import java.io.IOException;
import java.util.List;

import com.lowagie.text.DocumentException;
import com.petex.entity.AdoptionEntity;

public interface AdoptionService {
	
	public Boolean create(AdoptionEntity entity, Long userId) throws DocumentException, IOException;
	
	public  List<AdoptionEntity> getAllAdoptions();
}
