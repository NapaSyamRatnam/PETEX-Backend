package com.petex.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petex.entity.CommentsEntity;
import com.petex.entity.UserEntity;
import com.petex.repo.CommentsRepo;
import com.petex.repo.UserRepository;
import com.petex.service.CommentsService;

@Service
public class CommentsServiceImpl implements CommentsService {
	
	@Autowired
	private CommentsRepo repo;
	
	@Autowired
	private UserRepository userRepo;
	

	@Override
	public Boolean saveCommnet(CommentsEntity entity,Long userId) {
		Optional<UserEntity> optionalUserId = userRepo.findById(userId);
		System.out.println(optionalUserId);
		if (optionalUserId.isPresent()) {
			
			
			UserEntity user = optionalUserId.get();
			entity.setUser(user);
			repo.save(entity);
			return true;
		}
		return false;
	}

	@Override
    public CommentsEntity getUserById(Long userId) {
        Optional<CommentsEntity> optionalTestReport = repo.findById(userId);
        return optionalTestReport.orElse(null);
    }

	@Override
	public List<CommentsEntity> getAllUser() {
		
		// TODO Auto-generated method stub
		return repo.findAll();
	}




	@Override
	public CommentsEntity updateUser(Long id, CommentsEntity user) {
		
		
		return null;
	}




	@Override
	public String deleteUser(Long id) {
		repo.deleteById(id);
		return "deleted user successfully";
	}

	@Override
	public CommentsEntity getById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
