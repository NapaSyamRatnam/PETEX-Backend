package com.petex.service;

import java.util.List;

import com.petex.entity.CommentsEntity;

public interface CommentsService {

	public Boolean saveCommnet(CommentsEntity entity,Long userId);
	
	public List<CommentsEntity > getAllUser();

	CommentsEntity updateUser(Long id, CommentsEntity user);

	public String deleteUser(Long id);
	
	public CommentsEntity getById(Long userId);

	CommentsEntity getUserById(Long userId);



}
