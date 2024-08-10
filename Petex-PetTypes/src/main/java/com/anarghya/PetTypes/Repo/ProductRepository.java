package com.anarghya.PetTypes.Repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anarghya.PetTypes.Entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByCategory(String category);

//	List<Product> findByVegetarian(String  b);

	@Query("SELECT DISTINCT p.category FROM Product p")
    List<String> findAllCategories();

	@Query("SELECT DISTINCT p.category FROM Product p")
	List<String> getAllCategories();
}
