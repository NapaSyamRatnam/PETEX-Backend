package com.petshow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.petshow.entity.AdminshowEntity;
@Repository
public interface AdminshowRepository extends JpaRepository<AdminshowEntity, Integer> {

	List<AdminshowEntity> findByEventname(String location);

	
	@Query("SELECT DISTINCT p.location FROM AdminshowEntity  p")
    List<String> findAllByEventname();

	@Query("SELECT DISTINCT p.location FROM AdminshowEntity p")
	List<String> getAllByEventname();


	List<AdminshowEntity> findByLocation(String location);


	List<String> getAllByLocation(String location);
	
}
