package com.example.pet.Repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.pet.Entity.PetEntity;

@Repository
public interface PetRepo extends JpaRepository<PetEntity, Long> {

	List<PetEntity> findByCategory(String category);

//	List<Product> findByVegetarian(String  b);

	@Query("SELECT DISTINCT p.category FROM PetEntity p")
	List<String> findAllCategories();


	@Query("SELECT DISTINCT p.category FROM PetEntity p")
	List<String> getAllCategories();

}

