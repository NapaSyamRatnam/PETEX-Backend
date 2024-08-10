package com.petex.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petex.entity.AdoptionEntity;
import com.petex.repo.AdoptionRepo;
import com.petex.service.AdoptionService;

@Service
public class AdoptionServiceImpl implements AdoptionService {
	
	@Autowired
	private AdoptionRepo repo;

	@Override
	public Boolean saveAdtion(AdoptionEntity entity) {
		repo.save(entity);
		return true;
	}

}
